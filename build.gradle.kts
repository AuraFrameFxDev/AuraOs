@file:Suppress("DSL_SCOPE_VIOLATION")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Apply the Kotlin Gradle plugin to the root project
    kotlin("jvm") version "2.2.0" apply false
    
    // Apply the Android Gradle plugin
    id("com.android.application") version "8.11.1" apply false
    id("com.android.library") version "8.11.1" apply false
    
    // Apply other common plugins with versions from version catalog
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.ksp) apply false
    
    // OpenAPI Generator plugin
    id("org.openapi.generator") version "7.3.0" apply false
}

// Configure all projects (root + subprojects)
allprojects {
    // Apply common configuration to all projects
    group = "dev.aurakai.auraframefx"
    version = "1.0.0"

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // Add JitPack repository
        // Add Maven repositories for Compose and other dependencies
        maven { url = uri("https://androidx.dev/storage/compose-compiler/repository/") }
        maven { url = uri("https://androidx.dev/storage/compose_ui/repository/") }
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental") }
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev") }
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap") }
    }
}

// Configure all subprojects (excluding root)
subprojects {
    // Only apply Java plugin to specific modules that need it
    afterEvaluate {
        val isAndroidModule = plugins.hasPlugin("com.android.library") ||
                plugins.hasPlugin("com.android.application")

        if (!isAndroidModule && name != "app") {
            pluginManager.apply("java")
        }
    }

    // Configure Java toolchain for all projects
    plugins.withType<JavaBasePlugin> {
        extensions.configure<JavaPluginExtension> {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(17))
            }

            // For Android compatibility, don't set sourceCompatibility/targetCompatibility here
            // as it will be handled by the Android Gradle Plugin
            if (name == "buildSrc") {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }

        // Configure Java compilation tasks for non-Android projects
        if (name != "app") {
            tasks.withType<JavaCompile>().configureEach {
                sourceCompatibility = JavaVersion.VERSION_17.toString()
                targetCompatibility = JavaVersion.VERSION_17.toString()
            }
        }
    }

    // Configure Kotlin compilation for all projects with Kotlin plugin
    plugins.withType<org.jetbrains.kotlin.gradle.plugin.KotlinBasePlugin> {
        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = "17"
                apiVersion = "2.2"
                languageVersion = "2.2"
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-Xjvm-default=all",
                    "-opt-in=kotlin.RequiresOptIn",
                    "-opt-in=kotlin.ExperimentalStdlibApi"
                )
            }
        }
    }

    // Common test configuration
    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
            showStandardStreams = true
        }
    }
}

// Clean task for the root project
tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
    delete("${rootProject.projectDir}/build")
    delete("${rootProject.projectDir}/.idea")
}

