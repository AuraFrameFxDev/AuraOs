package plugins

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Convention plugin for the Assistant Jobs feature.
 * Configures background task scheduling and processing.
 */
class AssistantJobsConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        // Apply plugins
        target.pluginManager.apply("com.android.library")
        target.pluginManager.apply("org.jetbrains.kotlin.android")
        target.pluginManager.apply("com.google.dagger.hilt.android")
        target.pluginManager.apply("auraframefx.base.convention")

        // Add dependencies
        target.dependencies.add("implementation", "androidx.work:work-runtime-ktx:2.8.1")
        target.dependencies.add("implementation", "androidx.hilt:hilt-work:1.0.0")
        target.dependencies.add("kapt", "androidx.hilt:hilt-compiler:1.0.0")
        target.dependencies.add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
        target.dependencies.add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")
        target.dependencies.add("implementation", "com.google.code.gson:gson:2.10.1")

        // Configure Android extension
        val android = target.extensions.getByName("android") as LibraryExtension
        android.buildTypes.getByName("release").apply {
            isMinifyEnabled = true
            proguardFiles(
                android.getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
