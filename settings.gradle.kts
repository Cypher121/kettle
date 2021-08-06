pluginManagement {
    includeBuild("dependency-management")
}
includeBuild("build-logic")

enableFeaturePreview("VERSION_CATALOGS")

plugins {
    id("kettle.dependencies")
}

rootProject.name = "kettle"

include("modules:core")
//include("user-dist")