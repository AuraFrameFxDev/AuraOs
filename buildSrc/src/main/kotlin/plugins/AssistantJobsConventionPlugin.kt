package plugins

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * Convention plugin for the Assistant Jobs feature.
 * Configures background task scheduling and processing.
 */
class AssistantJobsConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            // Apply plugins
            pluginManager.apply("com.android.library")
            pluginManager.apply("org.jetbrains.kotlin.android")
            pluginManager.apply("com.google.dagger.hilt.android")
            pluginManager.apply("auraframefx.base.convention")

            // Add dependencies
            dependencies {
                add("implementation", "androidx.work:work-runtime-ktx:2.8.1")
                add("implementation", "androidx.hilt:hilt-work:1.0.0")
                add("kapt", "androidx.hilt:hilt-compiler:1.0.0")
                add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
                add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")
                add("implementation", "com.google.code.gson:gson:2.10.1")
            }

            // Configure Android extension
            extensions.configure<LibraryExtension> {
                buildTypes.getByName("release").apply {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
    }
}
