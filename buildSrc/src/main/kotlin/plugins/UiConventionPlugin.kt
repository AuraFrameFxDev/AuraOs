package plugins

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class UiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            pluginManager.apply("org.jetbrains.kotlin.android")
            pluginManager.apply("auraframefx.base.convention")

            // Add UI dependencies
            dependencies {
                add("implementation", "com.google.android.material:material:1.10.0")
                add("implementation", "androidx.compose:compose-bom:2023.08.00")
                add("implementation", "androidx.compose.material3:material3:1.2.0")
                add("implementation", "androidx.compose.material:material-icons-extended:1.4.3")
                add("implementation", "androidx.constraintlayout:constraintlayout-compose:1.0.1")
                add("implementation", "io.coil-kt:coil-compose:2.4.0")
                add("implementation", "androidx.navigation:navigation-compose:2.7.4")
                add("implementation", "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
                add("implementation", "androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
            }

            // Configure Android/Compose options
            extensions.configure<LibraryExtension> {
                buildFeatures.compose = true
                composeOptions.kotlinCompilerExtensionVersion = "1.5.3"
                buildTypes.getByName("release").apply {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
                sourceSets.getByName("main").java.srcDirs("src/main/kotlin")
                sourceSets.getByName("main").res.srcDirs(
                    "src/main/res",
                    "src/main/res/components",
                    "src/main/res/theme"
                )
            }
        }
    }
}