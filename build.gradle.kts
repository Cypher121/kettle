@file:Suppress("UnstableApiUsage", "UNCHECKED_CAST")

import groovy.json.JsonSlurper
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URL

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `maven-publish`
    signing
    alias(libs.plugins.kotlin)
    alias(libs.plugins.quilt.loom)
    alias(libs.plugins.dokka)
    alias(libs.plugins.nexus)
}

base {
    @Suppress("DEPRECATION")
    archivesBaseName = "kettle"
}

val modProps =
    JsonSlurper().parseText(File("mod.json").readText()) as Map<String, Any>

version = (modProps.getValue("core") as Map<String, Any>).getValue("version")
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
    mappings(
        variantOf(libs.quilt.mappings) {
            classifier("intermediary-v2")
        }
    )
    modImplementation(libs.quilt.loader)

    modImplementation(libs.bundles.kotlin)

    // TODO consider this
    // QSL is not a complete API; You will need Quilted Fabric API to fill in the gaps.
    // Quilted Fabric API will automatically pull in the correct QSL version.
    modImplementation(libs.bundles.qsl)

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
            //languageVersion = "2.0"
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

        outputDirectory.fileProvider(this@tasks.javadoc.map { it.destinationDir!! })
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

tasks {
    dokkaJavadoc {
        onlyIf { !project.hasProperty("publishOnly") }
    }

    javadoc {
        onlyIf { !project.hasProperty("publishOnly") }
    }

    remapJar {
        onlyIf { !project.hasProperty("publishOnly") }
    }

    remapSourcesJar {
        onlyIf { !project.hasProperty("publishOnly") }
    }
}

class Keystore(project: Project) {
    val pgpKey: String? by project
    val pgpPassword: String? by project

    val sonatypeUsername: String? by project
    val sonatypePassword: String? by project
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
        mavenLocal()
    }
}

nexusPublishing {
    this.repositories {
        sonatype {
            username.set(Keystore(project).sonatypeUsername.orEmpty())
            password.set(Keystore(project).sonatypePassword.orEmpty())
        }
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

tasks.register("prepareArtifacts", Copy::class) {
    group = "publishing"

    val artifactDir: String? by project

    dependsOn(tasks.remapJar, tasks.javadoc, tasks.remapSourcesJar)

    from(project.buildDir.resolve("libs")) {
        include("**/*.jar")
    }

    val destination = artifactDir?.let(::File)
        ?: project.buildDir.resolve("release")

    into(destination)
}

//endregion publishing
