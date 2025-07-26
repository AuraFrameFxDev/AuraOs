package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Convention plugin for the OracleDrive module.
 * Configures specific dependencies and settings required for OracleDrive functionality.
 */
class OracleDriveConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            pluginManager.apply("org.jetbrains.kotlin.android")
            pluginManager.apply("com.google.dagger.hilt.android")
            pluginManager.apply("auraframefx.base.convention")

            // OracleDrive specific dependencies
            dependencies.add("implementation", "com.google.apis:google-api-services-drive:v3-rev20230210-2.0.0")
            dependencies.add("implementation", "com.google.oauth-client:google-oauth-client-jetty:1.34.1")
            dependencies.add("implementation", "commons-io:commons-io:2.11.0")
            dependencies.add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
            dependencies.add("implementation", "androidx.work:work-runtime-ktx:2.8.1")

            // Configure ProGuard rules for release builds
            val android = extensions.getByName("android") as com.android.build.gradle.LibraryExtension
            android.buildTypes.getByName("release").apply {
                isMinifyEnabled = true
                proguardFiles(
                    android.getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
}
