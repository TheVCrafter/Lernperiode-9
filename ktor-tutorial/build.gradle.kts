plugins {
    kotlin("jvm") version "1.8.21"                 // Kotlin JVM
    id("io.ktor.plugin") version "2.3.3"          // Ktor plugin
    kotlin("plugin.serialization") version "1.8.21" // Kotlin Serialization plugin
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain") // Needed for EngineMain
}

kotlin {
    jvmToolchain(17) // JDK 17
}

repositories {
    mavenCentral()
}

dependencies {
    // Ktor
    implementation("io.ktor:ktor-server-core:2.3.3")
    implementation("io.ktor:ktor-server-netty:2.3.3")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
    implementation("ch.qos.logback:logback-classic:1.4.11")

    // Testing
    testImplementation("io.ktor:ktor-server-test-host:2.3.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.8.21")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}