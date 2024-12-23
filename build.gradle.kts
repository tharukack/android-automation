plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation ("io.appium:java-client:9.3.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.23.1")
    implementation("io.cucumber:cucumber-java:7.20.1")
    implementation("io.cucumber:cucumber-core:7.20.1")
    implementation("io.cucumber:cucumber-jvm:7.20.1")
    implementation("io.cucumber:cucumber-testng:7.20.1")
    testImplementation("org.testng:testng:7.10.2")


}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}