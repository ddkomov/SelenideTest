plugins {
    id("java")
    id("io.qameta.allure") version("2.12.0")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}



dependencies {
    testImplementation("io.qameta.allure:allure-selenide:2.21.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.aspectj:aspectjweaver:1.9.22.1")
    testImplementation("com.codeborne:selenide:7.3.3")
    testImplementation("io.qameta.allure:allure-junit5:2.25.0")
    testImplementation("io.qameta.allure:allure-assertj:2.25.0")
    testImplementation("io.qameta.allure:allure-java-commons:2.25.0")
    testImplementation("org.slf4j:slf4j-api:2.0.13")




}

tasks.test {
    useJUnitPlatform()
}