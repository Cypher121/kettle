rootProject.name = "kettle"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()

        maven("https://maven.quiltmc.org/repository/release") {
            name = "Quilt"
        }
        maven("https://maven.architectury.dev/")

        // Currently needed for Intermediary and other temporary dependencies
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
    }
}
