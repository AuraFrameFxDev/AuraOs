plugins {
    id("android-application-conventions")
    id("detekt-conventions")
    id("spotless-conventions")
    id("org.openapi.generator")
    alias(libs.plugins.kotlin.serialization) apply true
}

// Configure OpenAPI generation
openApiGenerate {
    generatorName.set("kotlin")
    inputSpec.set(rootProject.layout.projectDirectory.file("openapi.yml").asFile.path)
    outputDir.set(layout.buildDirectory.dir("generated/openapi").get().asFile.path)
    configFile.set(rootProject.layout.projectDirectory.file("openapi-generator-config.json").asFile.path)
    skipOverwrite.set(false)
    library.set("jvm-retrofit2")
    apiPackage.set("dev.aurakai.auraframefx.api.generated")
    modelPackage.set("dev.aurakai.auraframefx.model.generated")
    configOptions.set(mapOf(
        "useCoroutines" to "true",
        "serializationLibrary" to "kotlinx_serialization",
        "enumPropertyNaming" to "UPPERCASE",
        "parcelizeModels" to "true",
        "dateLibrary" to "java8"
    ))
}

// Add generated sources to the main source set
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

android {
    namespace = "dev.aurakai.auraframefx"

    defaultConfig {
        applicationId = "dev.aurakai.auraframefx"
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        
        // Enable vector drawable support
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    
    // Enable build features
    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }
    
    // Configure Compose compiler options
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    
    // Configure Java compilation options
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    
    // Configure Android resources
    androidResources {
        localeFilters.add("en")
    }
    
    // Enable split APKs by ABI for smaller APK sizes
    ndkVersion = "25.2.9519653" // Use the same version as specified below
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
        debug {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
    }

    // Configure packaging options for all build types
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

    buildFeatures {
        buildConfig = true
        // Compose is automatically enabled by the kotlin.compose plugin
    }

    // Enable ViewBinding for legacy views if needed
    buildFeatures.viewBinding = true

    // Enable data binding if needed
    // buildFeatures.dataBinding = true

    // Configure CMake for native code
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    // Configure NDK version
    ndkVersion = "25.2.9519653" // Use the latest stable NDK version

    // Compose compiler options
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/LICENSE.md"
            excludes += "META-INF/LICENSE-notice.md"
        }
    }
}

// OpenAPI Generator Configuration - Streamlined
openApiGenerate {
    generatorName.set("kotlin")
    inputSpec.set("$projectDir/src/main/openapi/aura-api.yaml")
    outputDir.set("${layout.buildDirectory.get().asFile}/generated/openapi")
    
    // Generator configuration
    configOptions.set(
        mapOf(
            "dateLibrary" to "java8",
            "useCoroutines" to "true",
            "collectionType" to "list",
            "enumPropertyNaming" to "UPPERCASE",
            "serializationLibrary" to "gson",
            "apiSuffix" to "Api",
            "modelSuffix" to "Dto"
        )
    )
    
    // Package configuration
    apiPackage.set("dev.aurakai.auraframefx.api.generated")
    modelPackage.set("dev.aurakai.auraframefx.api.model")
    invokerPackage.set("dev.aurakai.auraframefx.api.invoker")
    
    // Global properties
    globalProperties.set(
        mapOf(
            "apis" to "",
            "models" to "",
            "modelDocs" to "false"
        )
    )
}

// KSP Configuration
ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

// Source sets configuration
android.sourceSets.getByName("main") {
    java.srcDir("${layout.buildDirectory.get().asFile}/generated/openapi/src/main/kotlin")
}

// Task dependencies
tasks.named("preBuild") {
    dependsOn("openApiGenerate")
}

dependencies {
    // Core library desugaring for Java 8+ APIs on older Android versions
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")

    // Core AndroidX dependencies
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    // Compose dependencies
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Xposed Framework from local libs folder
    compileOnly(fileTree("${rootProject.projectDir}/Libs") {
        include("*.jar")
    })

    // LSPosed Framework
    compileOnly("org.lsposed.hiddenapibypass:hiddenapibypass:4.3")

    // Color Picker
    implementation("com.github.Mahmud0808:ColorBlendr:1.0.0")

    // Core Android
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")
    implementation("androidx.cardview:cardview:1.0.0")

    // Material 3 with BOM (Bill of Materials) - Using stable version
    val composeBom = platform("androidx.compose:compose-bom:2023.10.01")
    implementation(composeBom)
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-window-size-class")

    // Material3 Adaptive components - Temporarily disabled as they're not available in stable
    // implementation("androidx.compose.material3:material3-adaptive")
    // implementation("androidx.compose.material3:material3-adaptive-navigation-suite")

    // Material Icons Extended
    implementation("androidx.compose.material:material-icons-extended")

    // Material Components (for View-based components)
    implementation("com.google.android.material:material:1.11.0")

    // Compose dependencies from version catalog
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.debug)

    // Networking
    implementation(libs.okhttp.logging.interceptor)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.kotlinx.serialization)

    // DataStore & Security
    implementation(libs.bundles.security)

    // UI & Other
    implementation(libs.coil.compose)
    implementation(libs.timber)

    // Testing
    testImplementation(libs.bundles.testing.unit)

    // Android Testing
    androidTestImplementation(libs.bundles.testing.android)
    androidTestImplementation(libs.compose.ui.test.junit4)
    debugImplementation(libs.compose.ui.test.manifest)

    kspAndroidTest(libs.hilt.compiler)

    // Local color blending module
    implementation(project(":colorblendr"))
}