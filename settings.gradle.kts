pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        gradlePluginPortal()
    }
}

rootProject.name = "Steroids"
include("common")
include("client:fabric-1.21")
