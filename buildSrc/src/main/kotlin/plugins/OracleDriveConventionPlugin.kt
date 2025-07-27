package plugins

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

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
            dependencies {
                add("implementation", "com.google.apis:google-api-services-drive:v3-rev20230210-2.0.0")
                add("implementation", "com.google.oauth-client:google-oauth-client-jetty:1.34.1")
                add("implementation", "commons-io:commons-io:2.11.0")
                add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
                add("implementation", "androidx.work:work-runtime-ktx:2.8.1")
            }

            // Configure ProGuard rules for release builds
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
