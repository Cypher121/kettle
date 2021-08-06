import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

plugins {
    kotlin("jvm")
    id("fabric-loom")
    id("org.jetbrains.dokka")
}

dependencies {
    minecraft(libs.minecraft)

    mappings(libs.yarn.mappings) {
        artifact {
            classifier = "v2"
        }
    }

    modImplementation(libs.bundles.fabric)
    implementation(libs.bundles.kotlin)
}

val javaVersion = JavaVersion.VERSION_16

kotlin {
    explicitApi()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion.toString()))
    }

    withSourcesJar()
    withJavadocJar()
}

group = rootProject.group
version = rootProject.version

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"

        options.release.set(javaVersion.toString().toInt())
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = javaVersion.toString()
            freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }

    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") { expand(mutableMapOf("version" to project.version)) }
    }

    dokkaJekyll.configure {
        description = "Generates GitHub Pages reference for the project"

        outputDirectory.set(rootProject.projectDir.resolve("docs/reference"))
    }

    dokkaJavadoc.configure {
        description = "Generates Javadoc for the project"

        outputDirectory.set(tasks.javadoc.map { it.destinationDir!! })
    }

    withType<DokkaTask> {
        group = "documentation"

        dokkaSourceSets {
            configureEach {
                sourceLink {
                    //TODO
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