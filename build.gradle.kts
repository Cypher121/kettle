@file:Suppress("UnstableApiUsage")

import groovy.json.JsonOutput
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.*
import java.net.http.*

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `maven-publish`
    signing
    alias(libs.plugins.kotlin)
    alias(libs.plugins.quilt.loom)
    alias(libs.plugins.dokka)
    alias(libs.plugins.unipub)
}

base {
    @Suppress("DEPRECATION")
    archivesBaseName = "kettle"
}
version = "2.1.0+1.19"
group = "coffee.cypher.kettle"

repositories {
    mavenCentral()
}

sourceSets {
    val testmod by creating {
        compileClasspath += sourceSets.main.get().compileClasspath
        runtimeClasspath += sourceSets.main.get().runtimeClasspath
    }
}

// All the dependencies are declared at gradle/libs.version.toml and referenced with "libs.<id>"
// See https://docs.gradle.org/current/userguide/platforms.html for information on how version catalogs work.
dependencies {
    minecraft(libs.minecraft)
    mappings(loom.layered {
        addLayer(quiltMappings.mappings("org.quiltmc:quilt-mappings:${libs.versions.quilt.mappings.get()}:v2"))
    })
    modImplementation(libs.quilt.loader)

    implementation(libs.bundles.kotlin)

    // TODO consider this
    // QSL is not a complete API; You will need Quilted Fabric API to fill in the gaps.
    // Quilted Fabric API will automatically pull in the correct QSL version.
    "testmodImplementation"(libs.bundles.qsl)

    afterEvaluate {
        "testmodImplementation"(sourceSets.main.map { it.output })
    }
}

val javaVersion = JavaVersion.VERSION_17

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion.toString()))
    }

    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion

    withSourcesJar()
    withJavadocJar()
}

kotlin {
    explicitApi()

    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion.toString()))
    }
}

tasks {
    processResources {
        inputs.property("version", version)

        filesMatching("quilt.mod.json") {
            expand(mapOf("version" to version))
        }
    }

    withType<KotlinCompile> {
        kotlinOptions {
            useK2 = false
            jvmTarget = javaVersion.toString()
            freeCompilerArgs =
                listOf("-Xenable-builder-inference")
        }
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(javaVersion.toString().toInt())
    }

    jar {
        from("LICENSE") {
            rename { "${it}_${project.name}" }
        }
    }

    dokkaJekyll.configure {
        description = "Generates GitHub Pages reference for the project"

        outputDirectory.set(project.buildDir.resolve("docs/reference"))

        doFirst {
            delete(project.buildDir.resolve("docs/reference"))
        }
    }

    dokkaJavadoc.configure {
        description = "Generates Javadoc for the project"

        outputDirectory.set(this@tasks.javadoc.map { it.destinationDir!! })
    }

    withType<DokkaTask> {
        group = "documentation"

        dokkaSourceSets {
            configureEach {
                sourceLink {
                    localDirectory.set(projectDir.resolve("src/main/kotlin"))
                    remoteLineSuffix.set("#L")
                    remoteUrl.set(URL("https://github.com/Cypher121/kettle/blob/master/src/main/kotlin"))
                }

                jdkVersion.set(java.toolchain.languageVersion.get().asInt())

                reportUndocumented.set(true)
            }
        }
    }

    javadoc {
        dependsOn(dokkaJavadoc)

        taskActions.clear()
    }

    register("buildUserGuide", Copy::class) {
        group = "documentation"
        dependsOn(dokkaJekyll)

        from(projectDir.resolve("docs"))
        into(project.buildDir.resolve("docs"))
    }
}

//region publishing

class Keystore(project: Project) {
    val curseforgeToken: String? by project
    val modrinthToken: String? by project

    val pgpKey: String? by project
    val pgpPassword: String? by project

    val sonatypeUsername: String? by project
    val sonatypePassword: String? by project
}

tasks.register("validateKeys") {
    group = "verification"

    doFirst {
        with(Keystore(project)) {
            requireNotNull(pgpKey)
            requireNotNull(pgpPassword)

            requireNotNull(curseforgeToken)
            requireNotNull(modrinthToken)

            requireNotNull(sonatypeUsername)
            requireNotNull(sonatypePassword)

            val httpClient = HttpClient.newHttpClient()

            val cfRequest = HttpRequest
                .newBuilder(
                    URL("https://minecraft.curseforge.com/api/game/versions").toURI()
                )
                .header("X-Api-Token", curseforgeToken)
                .GET()
                .build()

            val cfResponse = httpClient.send(
                cfRequest, HttpResponse.BodyHandlers.ofString()
            )

            require(cfResponse.statusCode() == 200) {
                "CurseForge auth failed"
            }

            val modrinthRequest = HttpRequest
                .newBuilder(
                    URL("https://api.github.com").toURI()
                )
                .header("Authorization", "token $modrinthToken")
                .GET()
                .build()

            val modrinthResponse = httpClient.send(
                modrinthRequest, HttpResponse.BodyHandlers.ofString()
            )

            require(modrinthResponse.statusCode() == 200) {
                "Modrinth auth failed (via GitHub token)"
            }

            val ossClient = HttpClient.newBuilder()
                .authenticator(
                    object : Authenticator() {
                        override fun getPasswordAuthentication() =
                            PasswordAuthentication(
                                sonatypeUsername,
                                sonatypePassword?.toCharArray()
                            )
                    }
                )
                .build()

            val ossRequest = HttpRequest
                .newBuilder(
                    URL("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
                        .toURI()
                )
                .GET()
                .build()

            val ossResponse = ossClient.send(
                ossRequest, HttpResponse.BodyHandlers.ofString()
            )

            require(ossResponse.statusCode() !in listOf(401, 403)) {
                "Maven Central auth failed"
            }
        }
    }
}


unifiedPublishing {
    project {
        gameVersions.set(libs.versions.minecraft.map { listOf(it) })
        gameLoaders.set(listOf("quilt"))
        releaseType.set(
            when {
                "alpha" in project.version.toString() -> "alpha"
                "beta" in project.version.toString() -> "beta"
                else -> "release"
            }
        )

        mainPublication(tasks.remapJar.get())

        curseforge {
            token.set(Keystore(project).curseforgeToken.orEmpty())
            id.set("316905")
        }

        modrinth {
            token.set(Keystore(project).modrinthToken.orEmpty())
            id.set("SRCaBfKA")
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = group.toString()
            artifactId = project.name
            version = version.toString()

            from(components["java"])

            pom {
                name.set("Kettle")
                description.set("Kotlin mod utilities for Quilt")
                url.set("https://www.curseforge.com/minecraft/mc-mods/kettle/")

                scm {
                    connection.set("scm:git:git://github.com/Cypher121/kettle.git")
                    developerConnection.set("scm:git:ssh://github.com/Cypher121/kettle.git")
                    url.set("https://github.com/Cypher121/kettle/")
                }

                licenses {
                    license {
                        name.set("The MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                developers {
                    developer {
                        id.set("cypher121")
                        name.set("Cypher121")
                    }
                }
            }
        }
    }

    repositories {
        maven {
            url =
                uri("https://oss.sonatype.org/service/local/staging/deploy/maven2")

            credentials {
                username = Keystore(project).sonatypeUsername.orEmpty()
                password = Keystore(project).sonatypePassword.orEmpty()
            }
        }
        mavenLocal()
    }
}

signing {
    sign(publishing.publications)

    val keystore = Keystore(project)

    if (keystore.pgpKey != null) {
        useInMemoryPgpKeys(
            keystore.pgpKey,
            keystore.pgpPassword
        )
    }
}

tasks.register("publishAll") {
    group = "publishing"

    dependsOn(tasks.publish, tasks.publishUnified)
}

tasks.register("prepareGithubArtifacts", Copy::class) {
    group = "publishing"

    val artifactDir: String? by project

    dependsOn(tasks.remapJar, tasks.javadoc, tasks.remapSourcesJar)

    from(project.buildDir.resolve("libs")) {
        include("**/*.jar")
    }

    val parent = artifactDir?.let(::File)
        ?: project.buildDir.resolve("release")

    into(File(parent, "artifacts"))

    doLast {
        File(parent, "release.json").writeText(
            JsonOutput.toJson(
                mapOf(
                    "pre_release" to (
                        "alpha" in version.toString() ||
                            "beta" in version.toString()
                        ),
                    "version" to version,
                    "tag_name" to "v$version"
                )
            )
        )
    }
}

//endregion publishing
