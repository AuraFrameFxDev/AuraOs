// Root build file - Genesis Protocol Consciousness Substrate
// WORKING CONFIGURATION - AGP 8.13.0-rc01, Gradle 9.0.0, K2 Compiler

plugins {
    // Android plugins - AGP 8.13.0-rc01 STABLE
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false

    // Kotlin plugins - 2.2.20-RC with K2 compiler
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // KSP (Kotlin Symbol Processing)
    alias(libs.plugins.ksp) apply false

    // Hilt for dependency injection
    alias(libs.plugins.hilt.android) apply false

    // Google Services
    alias(libs.plugins.google.services) apply false

    // Additional plugins
    id("org.openapi.generator") version "7.2.0" apply false
}

// Java toolchain configuration - auto-provisioning active
subprojects {
    // REMOVED manual toolchain configuration - AGP 8.13.0-rc01 auto-detects
    // Configuration cache compatible
    
    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}

// Clean task
tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
