val kotlinVersion = "1.5.21"
val loomVersion = "0.9-SNAPSHOT"
val dokkaVersion = "1.5.0"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()

        maven("https://maven.fabricmc.net") {
            name = "Fabric"
        }
    }

    plugins {
        kotlin("jvm") version kotlinVersion
        id("fabric-loom") version loomVersion
        id("org.jetbrains.dokka") version dokkaVersion
    }
}

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()

        maven("https://maven.fabricmc.net") {
            name = "Fabric"
        }

        maven {
            name = "geckolib"
            url = uri("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
        }
    }

    versionCatalogs {
        create("pluginDeps") {
            alias("kotlin").to("org.jetbrains.kotlin", "kotlin-gradle-plugin").version(kotlinVersion)
            alias("loom").to("fabric-loom", "fabric-loom.gradle.plugin").version(loomVersion)
            alias("dokka").to("org.jetbrains.dokka", "dokka-gradle-plugin").version(dokkaVersion)

            bundle("common", listOf("kotlin", "loom", "dokka"))
        }

        create("libs") {
            version("minecraft", "1.17.1")

            version("kotlin") {
                prefer("latest.release")
                require(kotlinVersion)
            }


            alias("minecraft").to("com.mojang", "minecraft").versionRef("minecraft")

            alias("yarn-mappings").to("net.fabricmc", "yarn").version("1.17.1+build.32")

            alias("fabric-loader").to("net.fabricmc", "fabric-loader").version("0.11.6")
            alias("fabric-api").to("net.fabricmc.fabric-api", "fabric-api").version("0.37.1+1.17")
            alias("fabric-language-kotlin").to("net.fabricmc", "fabric-language-kotlin").version("1.6.3+kotlin.$kotlinVersion")

            alias("gecko").to("software.bernie.geckolib", "geckolib-fabric-1.17").version("3.0.10")

            alias("kotlin-stdlib-jdk8").to("org.jetbrains.kotlin", "kotlin-stdlib-jdk8").versionRef("kotlin")
            alias("kotlin-reflect").to("org.jetbrains.kotlin", "kotlin-reflect").versionRef("kotlin")

            bundle("fabric", listOf("fabric-loader", "fabric-api", "fabric-language-kotlin"))
            bundle("kotlin", listOf("kotlin-stdlib-jdk8", "kotlin-reflect"))
        }
    }
}
