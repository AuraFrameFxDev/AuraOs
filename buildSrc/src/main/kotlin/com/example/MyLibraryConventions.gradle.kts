package com.example

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.*
import org.gradle.api.artifacts.VersionCatalogsExtension

class MyLibraryConventionsPlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = project.run {
        plugins.apply("com.android.library")
        plugins.apply("org.jetbrains.kotlin.jvm")
        plugins.apply("com.google.devtools.ksp")
        plugins.apply("com.google.dagger.hilt.android")

        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        extensions.configure<LibraryExtension> {
            compileSdk = 36
            defaultConfig {
                minSdk = 33
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_24
                targetCompatibility = JavaVersion.VERSION_1_24
            }
        }

        dependencies {
            add("implementation", libs.findLibrary("core-ktx").get())
            add("implementation", libs.findLibrary("hilt-android").get())
            add("ksp", libs.findLibrary("hilt-compiler").get())
            add("testImplementation", libs.findLibrary("junit").get())
        }
    }
}
