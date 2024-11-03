plugins {
    id("java")
}

group = "ru.artem.alaverdyan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(fileTree("libs") {
        include("*.jar")
    })
}

tasks.test {
    useJUnitPlatform()
}