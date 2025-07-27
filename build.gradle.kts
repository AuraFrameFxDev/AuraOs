// Root build file - manages plugin versions and common configuration
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.openapi.generator) apply false
    alias(libs.plugins.detekt) apply false
}

// Configure repositories for all projects
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

// Common configuration for all subprojects
subprojects {
    plugins.withType<JavaBasePlugin> {
        extensions.configure<JavaPluginExtension> {
            toolchain.languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    plugins.withType<org.jetbrains.kotlin.gradle.plugin.KotlinBasePlugin> {
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = "17"
                apiVersion = "2.2"
                languageVersion = "2.2"
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-Xjvm-default=all",
                    "-opt-in=kotlin.RequiresOptIn"
                )
            }
        }
    }

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
}