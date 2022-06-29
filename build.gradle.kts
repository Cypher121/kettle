@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    `maven-publish`
    signing
    alias(libs.plugins.kotlin)
    alias(libs.plugins.quilt.loom)
    alias(libs.plugins.dokka)
    alias(libs.plugins.unipub)
}

apply(plugin = "org.jetbrains.dokka")

base {
    @Suppress("DEPRECATION")
    archivesBaseName = "kettle"
}
version = "2.1.0+1.19"
group = "coffee.cypher.kettle"

repositories {
    mavenCentral()
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
    modImplementation(libs.qsl)
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
            useK2 = true
            jvmTarget = javaVersion.toString()
            freeCompilerArgs = listOf("-Xenable-builder-inference")
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

        outputDirectory.set(projectDir.resolve("docs/reference"))
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
                platform.set(org.jetbrains.dokka.Platform.jvm)

                reportUndocumented.set(true)
            }
        }
    }

    javadoc { dependsOn(dokkaJavadoc) }
}

unifiedPublishing {
    project {
        gameVersions.set(libs.versions.minecraft.map { listOf(it) })
        gameLoaders.set(listOf("quilt"))
        releaseType.set(when {
            "alpha" in project.version.toString() -> "alpha"
            "beta" in project.version.toString() -> "beta"
            else -> "release"
        })

        mainPublication(tasks.remapJar.get())

        curseforge {
            val curseforgeApiKey: String? by project

            token.set(curseforgeApiKey.orEmpty())
            id.set("316905")
        }

        modrinth {
            val modrinthApiKey: String? by project

            token.set(modrinthApiKey.orEmpty())
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
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2")

            credentials {
                val sonatypeUsername: String? by project
                val sonatypePassword: String? by project

                username = sonatypeUsername.orEmpty()
                password = sonatypePassword.orEmpty()
            }
        }
        mavenLocal()
    }
}

signing {
    sign(publishing.publications)
}
