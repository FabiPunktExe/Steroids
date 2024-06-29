plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:24.1.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release = 21
    }

    test {
        useJUnitPlatform()
    }
}
