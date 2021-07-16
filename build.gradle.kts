import com.matthewprenger.cursegradle.CurseProject
import com.matthewprenger.cursegradle.CurseRelation
import com.modrinth.minotaur.TaskModrinthUpload
import com.modrinth.minotaur.request.VersionType
import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    id("fabric-loom")
    kotlin("jvm")

    id("org.jetbrains.dokka") version "1.5.0"

    id("com.matthewprenger.cursegradle") version "1.4.0"
    id("com.modrinth.minotaur") version "1.2.1"

    `maven-publish`
    signing
}

base {
    val archivesBaseName: String by project
    archivesName.set(archivesBaseName)
}

val modVersion: String by project
version = modVersion

val mavenGroup: String by project
group = mavenGroup

val javaVersion = JavaVersion.VERSION_16

minecraft {}

repositories {}

dependencies {
    val minecraftVersion: String by project
    minecraft("com.mojang:minecraft:$minecraftVersion")

    val yarnMappings: String by project
    mappings("net.fabricmc:yarn:$yarnMappings:v2")

    val loaderVersion: String by project
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")

    val fabricVersion: String by project
    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabricVersion")

    val fabricKotlinVersion: String by project
    modImplementation("net.fabricmc:fabric-language-kotlin:$fabricKotlinVersion")
}

kotlin {
    explicitApi()
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"

        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        options.release.set(javaVersion.toString().toInt())
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = javaVersion.toString()
            freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
    }

    jar { from("LICENSE") { rename { "${it}_${base.archivesName}" } } }

    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") { expand(mutableMapOf("version" to project.version)) }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersion.toString()))
        }

        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
        withSourcesJar()
    }
}

tasks.register<Copy>("installGitHooks") {
    group = "build setup"
    description = "Installs recommended git hooks for the project"
    duplicatesStrategy = DuplicatesStrategy.INCLUDE

    from("git_hooks")
    into(".git/hooks")
}

//Docs

fun DokkaTask.commonConfig() {
    group = "documentation"

    dokkaSourceSets {
        configureEach {
            sourceLink {
                localDirectory.set(projectDir.resolve("src/main/kotlin"))
                remoteLineSuffix.set("#L")
                remoteUrl.set(URL("https://github.com/Cypher121/kettle/blob/master/src/main/kotlin"))
            }

            jdkVersion.set(javaVersion.toString().toInt())
            platform.set(org.jetbrains.dokka.Platform.jvm)

            reportUndocumented.set(true)
        }
    }
}

tasks.dokkaGfm.configure {
    description = "Generates GitHub Markdown reference for the project"

    outputDirectory.set(projectDir.resolve("docs/reference"))
    commonConfig()
}

tasks.dokkaJavadoc.configure {
    description = "Generates Javadoc for the project"

    outputDirectory.set(tasks.javadoc.map { it.destinationDir!! })
    commonConfig()
}

val javadocJar by tasks.registering(Jar::class) {
    group = "build"
    description = "Create a Javadoc artifact"

    archiveClassifier.set("javadoc")
    from(tasks.javadoc)

    dependsOn(tasks.dokkaJavadoc)
}

val sourcesJar by tasks

tasks.assemble {
    dependsOn(sourcesJar, javadocJar)
}


// Publishing

val minecraftVersion: String by project

curseforge {
    val curseforgeApiKey: String by project
    apiKey = curseforgeApiKey

    curseGradleOptions.forgeGradleIntegration = false

    project(closureOf<CurseProject> {
        id = "316905"
        releaseType = when {
            "alpha" in version.toString() -> "alpha"
            "beta" in version.toString() -> "beta"
            else -> "release"
        }

        addGameVersion(minecraftVersion)
        addGameVersion("Fabric")

        mainArtifact(tasks.remapJar.get().archiveFile)

        afterEvaluate {
            uploadTask.dependsOn(tasks.remapJar)
        }

        relations(closureOf<CurseRelation> {
            requiredDependency("fabric-language-kotlin")
        })
    })
}

val modrinth by tasks.registering(TaskModrinthUpload::class) {
    val modrinthApiKey: String by project

    detectLoaders = true

    token = modrinthApiKey
    projectId = "SRCaBfKA"

    uploadFile = tasks.remapJar.get().archiveFile

    addGameVersion(minecraftVersion)

    versionNumber = modVersion
    versionType = when {
        "alpha" in version.toString() -> VersionType.ALPHA
        "beta" in version.toString() -> VersionType.BETA
        else -> VersionType.RELEASE
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = mavenGroup
            artifactId = project.name
            version = modVersion

            artifact(tasks.remapJar)
            artifact(javadocJar)
            artifact(sourcesJar)

            pom {
                name.set("Kettle")
                description.set("Kotlin mod utilities for Fabric")
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
                val ossUsername: String by project
                val ossPassword: String by project

                username = ossUsername
                password = ossPassword
            }
        }
        mavenLocal()
    }
}

signing {
    sign(publishing.publications)
}

tasks.register("release") {
    group = "publishing"
    dependsOn(tasks.publish, tasks.curseforge, modrinth)
}