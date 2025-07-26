package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.LibraryExtension

class UiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.library")
        target.pluginManager.apply("org.jetbrains.kotlin.android")
        target.pluginManager.apply("auraframefx.base.convention")

        // Add UI dependencies
        target.dependencies.add("implementation", "com.google.android.material:material:1.10.0")
        target.dependencies.add("implementation", "androidx.compose:compose-bom:2023.08.00")
        target.dependencies.add("implementation", "androidx.compose.material3:material3:1.2.0")
        target.dependencies.add("implementation", "androidx.compose.material:material-icons-extended:1.4.3")
        target.dependencies.add("implementation", "androidx.constraintlayout:constraintlayout-compose:1.0.1")
        target.dependencies.add("implementation", "io.coil-kt:coil-compose:2.4.0")
        target.dependencies.add("implementation", "androidx.navigation:navigation-compose:2.7.4")
        target.dependencies.add("implementation", "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
        target.dependencies.add("implementation", "androidx.lifecycle:lifecycle-runtime-compose:2.6.2")

        // Configure Android/Compose options
        val android = target.extensions.findByType(LibraryExtension::class.java) ?: return
        android.buildFeatures.compose = true
        android.composeOptions.kotlinCompilerExtensionVersion = "1.5.3"
        android.buildTypes.getByName("release").apply {
            isMinifyEnabled = true
            proguardFiles(
                android.getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        android.sourceSets.getByName("main").java.srcDirs("src/main/kotlin")
        android.sourceSets.getByName("main").res.srcDirs(
            "src/main/res",
            "src/main/res/components",
            "src/main/res/theme"
        )
    }
}