package plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Base convention plugin that sets up common configurations for all AuraFrameFX modules.
 * This plugin should be applied to all modules in the project.
 */
abstract class AuraBaseConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.android")
            pluginManager.apply("com.google.dagger.hilt.android")

            // Common Android configurations
            val android = extensions.getByName("android") as BaseExtension
            android.compileSdkVersion(34)
            android.defaultConfig.apply {
                minSdk = 24
                targetSdk = 34
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            android.compileOptions.apply {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
            android.buildTypes.getByName("release").apply {
                isMinifyEnabled = true
                proguardFiles(
                    android.getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }

            // Add dependencies using Kotlin DSL
            dependencies.add("implementation", "androidx.core:core-ktx:1.12.0")
            dependencies.add("testImplementation", "junit:junit:4.13.2")
            dependencies.add("androidTestImplementation", "androidx.test.ext:junit:1.1.5")
            dependencies.add("androidTestImplementation", "androidx.test.espresso:espresso-core:3.5.1")
        }
    }
}
