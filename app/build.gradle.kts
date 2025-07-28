plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.google.services)
    alias(libs.plugins.firebase.perf)
    alias(libs.plugins.firebase.crashlytics)
}

// OpenAPI Generator Configuration
// (Moved to root build.gradle.kts)

// Add generated OpenAPI sources to the main source set
android.sourceSets.getByName("main") {
    java.srcDir(layout.buildDirectory.dir("generated/openapi/src/main/kotlin"))
}

// Ensure OpenAPI generation happens before compilation
tasks.named("preBuild") {
    dependsOn("openApiGenerate")
}

// Clean task for generated files
tasks.register("cleanOpenApi", Delete::class) {
    delete(layout.buildDirectory.dir("generated/openapi"))
}

tasks.clean {
    dependsOn("cleanOpenApi")
}

// KSP Configuration (needs to be after plugin application)
ksp {
    arg("hilt.allow.experimental.multiplatform.support", "true")
    // Add other KSP arguments here
}

android {
    namespace = "dev.aurakai.auraframefx"
    compileSdk = 36

    defaultConfig {
        applicationId = "dev.aurakai.auraframefx"
        minSdk = 33
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true

        // Enable vector drawable support
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    // Enable build features (Consolidated)
    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true // Explicitly enable compose
        // dataBinding = true // Uncomment if you need DataBinding
    }

    // Compose compiler options should use the version from the version catalog
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }

    // Configure Java compatibility (Corrected JavaVersion enum)
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(24)
        targetCompatibility = JavaVersion.toVersion(24)
        isCoreLibraryDesugaringEnabled = true
    }

    // Configure Java Toolchain (Keep this block if you want Gradle to manage JDK versions)
    // This typically ensures the correct JDK is used for all Java/Kotlin tasks.
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(24))
        }
    }
    // Removed redundant tasks.withType<JavaCompile>() block as toolchain should handle this.

    // Configure Android resources
    androidResources {
        localeFilters.add("en")
    }

    // Configure CMake for native code
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.29.2"
        }
    }

    // Specify NDK version (Only once)
    ndkVersion = "26.2.11394342"

    // Enable split APKs by ABI for smaller APK sizes
    splits {
        abi {
            isEnable = true
            reset()
            include("armeabi-v7a", "arm64-v8a", "x86_64")
            isUniversalApk = false
        }
    }

    // Configure build types
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
    }

    // Configure packaging options for all build types (Combined block)
    packaging {
        resources {
            // Keep debug symbols for native libraries in debug builds
            jniLibs.keepDebugSymbols.add("**/*.so")

            // Common resource exclusions
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/LICENSE.md"
            excludes += "META-INF/LICENSE-notice.md"
        }
    }

    // This section is for Kotlin-specific source set configuration,
    // which may be needed depending on your project structure or testing setup.
    // Ensure the kotlin block is available at this level if required.
    // kotlin {
    //    sourceSets {
    //        getByName("debug").kotlin.srcDirs("src/debug/kotlin")
    //    }
    // }
}

// This 'java' block and 'tasks.withType<JavaCompile>()' also needs to be outside the 'android' block
// and should preferably be replaced by the toolchain setup in the root build.gradle.kts or a convention plugin
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}
tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = JavaVersion.VERSION_1_24.toString()
    targetCompatibility = JavaVersion.VERSION_1_24.toString()
}

// Ensure the dependencies block is correctly placed as a top-level block
// OR, if you choose to put it inside the 'android' block, ensure it's inside
// and the 'java' and 'tasks.withType' blocks are outside 'android'.
dependencies {
    // Correct declarations using version catalog aliases
    implementation(libs.androidx.core)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(platform(libs.androidx.compose.bom)) // BOM declaration must come first
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler) // Note: ksp() is a special configuration, not 'implementation'
    implementation(libs.hilt.navigation.compose)
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler) // Note: ksp() is a special configuration, not 'implementation'
    implementation(libs.datastore.preferences)
    implementation(libs.datastore.core)
    implementation(libs.coil.compose)
    implementation(libs.timber)
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.espresso.core)
    coreLibraryDesugaring(libs.coreLibraryDesugaring)
}
