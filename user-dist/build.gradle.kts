plugins {
    id("com.github.johnrengelman.shadow")
    kotlin("jvm")

    id("com.matthewprenger.cursegradle")
    id("com.modrinth.minotaur")
}

dependencies {
    implementation(project(":core"))
}


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

        addGameVersion(libs.versions.minecraft.get())
        addGameVersion("Fabric")

        mainArtifact(tasks.withType<net.fabricmc.loom.task.RemapJarTask>().named("remapJar").get().archiveFile)

        afterEvaluate {
            uploadTask.dependsOn(tasks.named("remapJar"))
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

    uploadFile = tasks.withType<net.fabricmc.loom.task.RemapJarTask>().named("remapJar").get().archiveFile

    addGameVersion(libs.versions.minecraft.get())

    versionNumber = version.toString()

    versionType = when {
        "alpha" in version.toString() -> VersionType.ALPHA
        "beta" in version.toString() -> VersionType.BETA
        else -> VersionType.RELEASE
    }
}