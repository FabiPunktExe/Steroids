plugins {
    id("java")
    id("fabric-loom") version "1.6-SNAPSHOT"
}

repositories {
    mavenCentral()
}

val loaderVersion = "0.15.11"

dependencies {
    implementation(project(":common"))
    minecraft("com.mojang:minecraft:1.21")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.100.3+1.21")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
    withSourcesJar()
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release = 21
    }

    processResources {
        filesMatching("fabric.mod.json") {
            expand(mapOf("version" to version, "loader_version" to loaderVersion))
        }
    }

    jar {
        from("LICENSE") {
            rename { "${it}_$archiveBaseName" }
        }
    }
}
