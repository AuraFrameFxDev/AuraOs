// Top-level build file for AuraFrameFX project
// Configure build settings and plugins for all subprojects

// Enable Gradle's configuration cache for faster builds
@file:Suppress("DSL_SCOPE_VIOLATION")

// Apply core plugins with versions from settings.gradle.kts

plugins {
    // other plugins if needed
}

// Configure all projects (root + subprojects)
allprojects {
    // Apply common configuration to all projects
    group = "dev.aurakai.auraframefx"
    version = "1.0.0"
}

// Configure all subprojects (excluding root)
subprojects {
    // Apply Java plugin to non-Android projects
    if (project.name != "app") {
        pluginManager.apply("java")
    }

    // Configure Java toolchain for all projects
    plugins.withType<JavaBasePlugin> {
        extensions.configure<JavaPluginExtension> {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(if (project.name == "buildSrc") 22 else 24))
            }
            sourceCompatibility =
                if (project.name == "buildSrc") JavaVersion.VERSION_22 else JavaVersion.VERSION_24
            targetCompatibility =
                if (project.name == "buildSrc") JavaVersion.VERSION_22 else JavaVersion.VERSION_24
        }

        // Configure Java compilation tasks
        tasks.withType<JavaCompile>().configureEach {
            // Use the compatibility set above
            options.release.set(if (project.name == "buildSrc") 22 else 24)
        }
    }

    // Remove this block to avoid duplicate plugin application
    // pluginManager.withPlugin("com.android.application") {
    //     pluginManager.apply("org.jetbrains.kotlin.android")
    //     extensions.configure<com.android.build.gradle.BaseExtension> {
    //         compileSdkVersion(34)
    //         defaultConfig {
    //             minSdk = 24
    //             targetSdk = 34
    //         }
    //         compileOptions {
    //             sourceCompatibility = JavaVersion.VERSION_17
    //             targetCompatibility = JavaVersion.VERSION_17
    //             isCoreLibraryDesugaringEnabled = true
    //         }
    //     }
    //     extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension> {
    //         jvmToolchain(17)
    //         compilerOptions {
    //             jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    //         }
    //     }
    // }
    // Common test configuration
    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
            showStandardStreams = true
        }
    }

    // Configure Kotlin compilation
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
            // Use string literals for Kotlin version to avoid deprecation warnings
            apiVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.fromVersion("2.2"))
            languageVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.fromVersion("2.2"))
            freeCompilerArgs.addAll(
                "-Xjvm-default=all",
                "-opt-in=kotlin.RequiresOptIn"
            )
        }
    }
}

// Clean task for the root project
tasks.register<Delete>("clean") {
    delete(layout.buildDirectory)
    delete("${projectDir}/build")
    delete("${projectDir}/.idea")
}

repositories {
    google()
    mavenCentral()
}
