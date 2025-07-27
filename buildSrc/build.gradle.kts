// Top-level build file for buildSrc
plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "1.3.1"
    kotlin("jvm") version "2.2.0"
}

// Define versions in the build file since buildSrc can't access the version catalog directly
object Versions {
    // Core
    const val kotlin = "2.2.0"
    const val agp = "8.11.1"
    const val ksp = "2.2.0-2.0.2"

    // Dependencies
    const val hilt = "2.57"  // Must be >= 2.56.2 due to KSP compatibility issues

    // Test
    const val junit = "4.13.2"
}

// Configure Java toolchain
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}

// Configure repositories for buildSrc
repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")

    // Android Gradle Plugin
    implementation("com.android.tools.build:gradle:${Versions.agp}")

    // KSP
    implementation("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${Versions.ksp}")

    // Hilt
    implementation("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
}

// Configure Gradle plugin publishing
gradlePlugin {
    plugins {
        register("auraBaseConvention") {
            id = "auraframefx.base.convention"
            implementationClass = "plugins.AuraBaseConventionPlugin"
            displayName = "AuraFrameFX Base Convention Plugin"
            description = "Base convention plugin for all AuraFrameFX modules"
        }
        register("romTooling") {
            id = "auraframefx.romtooling"
            implementationClass = "plugins.RomToolingPlugin"
            displayName = "AuraFrameFX ROM Tooling"
            description = "Plugin for ROM building and management tasks"
        }
        register("oracleDrive") {
            id = "auraframefx.oracledrive"
            implementationClass = "plugins.OracleDriveConventionPlugin"
            displayName = "AuraFrameFX OracleDrive"
            description = "Convention plugin for OracleDrive module"
        }
        register("assistantJobs") {
            id = "auraframefx.assistant.jobs"
            implementationClass = "plugins.AssistantJobsConventionPlugin"
            displayName = "AuraFrameFX Assistant Jobs"
            description = "Convention plugin for background job processing"
        }
        register("uiConventions") {
            id = "auraframefx.ui.conventions"
            implementationClass = "plugins.UiConventionPlugin"
            displayName = "AuraFrameFX UI Conventions"
            description = "Convention plugin for UI theming and components"
        }
        register("auraBasePlugin") {
            id = "dev.aurakai.aura.base"
            implementationClass = "dev.aurakai.aura.gradle.AuraBasePlugin"
            displayName = "Aura Base Plugin"
            description = "Base plugin for Aura projects"
        }
    }
}

// Configure Kotlin settings for buildSrc
kotlin {
    jvmToolchain(17)

    // Ensure consistent Kotlin stdlib version
    sourceSets.all {
        languageSettings {
            languageVersion = "2.2"
            apiVersion = "2.2"
        }
    }
}

// Force Kotlin version for all dependencies
configurations.all {
    resolutionStrategy {
        eachDependency {
            if (requested.group == "org.jetbrains.kotlin") {
                useVersion("2.2.0")
            }
        }
    }
}

// Configure the plugin bundle extension (for publishing to Gradle Plugin Portal)

// Test dependencies for buildSrc
dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}")
    testImplementation("org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}")
}

// Configure Kotlin compiler options
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        freeCompilerArgs.addAll(listOf(
            "-Xjsr305=strict",
            "-opt-in=kotlin.RequiresOptIn",
            "-Xjvm-default=all"
        ))
    }
}

// Configure Java toolchain
tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
}

// Configure tests
tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}
