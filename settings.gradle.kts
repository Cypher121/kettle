//https://fabricmc.net/versions.html
pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net") { name = "Fabric" }
        gradlePluginPortal()
    }

    plugins {
        id("fabric-loom").version("0.9-SNAPSHOT")
        kotlin("jvm").version("1.5.20")
    }
}

plugins {
    id("fabric-loom")
}

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories {
        maven {
            name = "geckolib"
            url = uri("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
        }
    }

    versionCatalogs {
        create("libs") {
            version("minecraft", "1.17.1")
            alias("minecraft").to("com.mojang", "minecraft").versionRef("minecraft")

            alias("yarn-mappings").to("net.fabricmc", "yarn").version("1.17.1+build.25")

            alias("fabric-loader").to("net.fabricmc", "fabric-loader").version("0.11.6")
            alias("fabric-api").to("net.fabricmc.fabric-api", "fabric-api").version("0.37.0+1.17")
            alias("fabric-language-kotlin").to("net.fabricmc", "fabric-language-kotlin").version("1.6.2+kotlin.1.5.20")

            bundle("fabric", listOf("fabric-loader", "fabric-api", "fabric-language-kotlin"))

            alias("gecko").to("software.bernie.geckolib", "geckolib-fabric-1.17").version("3.0.10")
        }
    }
}