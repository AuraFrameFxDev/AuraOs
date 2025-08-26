plugins {
    // APP MODULE - Only plugins THIS module needs (inherit versions from root)
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    id("org.openapi.generator")
}

android {
    namespace = "dev.auraframefx.auraframefx"
    compileSdk = 36

    defaultConfig {
        applicationId = "dev.aurakai.auraframefx"
        minSdk = 33
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0-genesis-alpha"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

        ndk {
            abiFilters.addAll(listOf("arm64-v8a", "armeabi-v7a", "x86_64", "x86"))
        }

        externalNativeBuild {
            cmake {
                cppFlags += listOf(
                    "-std=c++20",
                    "-fPIC",
                    "-O2",
                    "-Wno-unused-parameter",
                    "-Wno-unused-function"
                )
                arguments += listOf(
                    "-DANDROID_STL=c++_shared",
                    "-DANDROID_PLATFORM=android-33",
                    "-DCMAKE_BUILD_TYPE=Release",
                    "-DCMAKE_FIND_ROOT_PATH_MODE_LIBRARY=BOTH",
                    "-DCMAKE_FIND_ROOT_PATH_MODE_INCLUDE=BOTH"
                )
            }
        }
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            // Let Android Studio auto-detect the best CMake version
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes += setOf(
                "/META-INF/{AL2.0,LGPL2.1}",
                "/META-INF/DEPENDENCIES",
                "/META-INF/LICENSE",
                "/META-INF/LICENSE.txt",
                "/META-INF/NOTICE",
                "/META-INF/NOTICE.txt",
                "META-INF/*.kotlin_module",
                "**/kotlin/**",
                "**/*.txt",
                "**/*.xml"
            )
        }
        jniLibs {
            useLegacyPackaging = false
            pickFirsts += listOf("**/libc++_shared.so", "**/libjsc.so")
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
        viewBinding = false
    }

    sourceSets {
        getByName("main") {
            java.srcDirs(
                layout.buildDirectory.dir("generated/source/openapi/src/main/kotlin")
            )
        }
    }

    // Let Android Studio auto-detect NDK version from SDK Manager
}

// FIXED: OpenAPI Configuration - Correct path to api-spec folder
val consolidatedSpecsPath = layout.projectDirectory.dir("api-spec")
val outputPath = layout.buildDirectory.dir("generated/source/openapi")

val sharedApiConfig = mapOf(
    "library" to "jvm-retrofit2",
    "useCoroutines" to "true",
    "serializationLibrary" to "kotlinx_serialization",
    "dateLibrary" to "kotlinx-datetime",
    "sourceFolder" to "src/main/kotlin"
)

fun createApiTaskSafe(taskName: String, specFile: String, packagePrefix: String) =
    tasks.register<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>(taskName) {
        val specPath = consolidatedSpecsPath.file(specFile).asFile

        generatorName.set("kotlin")

        // DEBUG: Print actual path being checked
        logger.lifecycle("[DEBUG] Checking OpenAPI spec: ${specPath.absolutePath}")
        logger.lifecycle("[DEBUG] File exists: ${specPath.exists()}")
        if (specPath.exists()) {
            logger.lifecycle("[DEBUG] File size: ${specPath.length()} bytes")
        }

        if (specPath.exists() && specPath.length() > 0) {
            logger.lifecycle("[DEBUG] SUCCESS: Using spec file $specFile")
            inputSpec.set(specPath.toURI().toString())
            outputDir.set(outputPath.get().asFile.absolutePath)
            packageName.set("dev.aurakai.$packagePrefix.api")
            apiPackage.set("dev.aurakai.$packagePrefix.api")
            modelPackage.set("dev.aurakai.$packagePrefix.model")
            invokerPackage.set("dev.aurakai.$packagePrefix.client")
            skipOverwrite.set(false)
            validateSpec.set(false)
            generateApiTests.set(false)
            generateModelTests.set(false)
            generateApiDocumentation.set(false)
            generateModelDocumentation.set(false)
            configOptions.set(sharedApiConfig)
        } else {
            logger.warn("OpenAPI spec file not found or empty: $specFile")
            inputSpec.set("")
            outputDir.set(outputPath.get().asFile.absolutePath)
            packageName.set("dev.aurakai.$packagePrefix.api")
            configOptions.set(sharedApiConfig)
            onlyIf { false }
        }
    }

// Configure the main Genesis API
openApiGenerate {
    val specFile = consolidatedSpecsPath.file("genesis-api.yml").asFile
    if (specFile.exists() && specFile.length() > 0) {
        generatorName.set("kotlin")
        inputSpec.set(specFile.toURI().toString())
        outputDir.set(outputPath.get().asFile.absolutePath)
        packageName.set("dev.aurakai.genesis.api")
        apiPackage.set("dev.aurakai.genesis.api")
        modelPackage.set("dev.aurakai.genesis.model")
        invokerPackage.set("dev.aurakai.genesis.client")
        skipOverwrite.set(false)
        validateSpec.set(false)
        generateApiTests.set(false)
        generateModelTests.set(false)
        generateApiDocumentation.set(false)
        generateModelDocumentation.set(false)
        configOptions.set(sharedApiConfig)
    } else {
        logger.warn("Genesis API spec file not found: genesis-api.yml")
    }
}

// Create all consciousness API tasks
val generateAiApi = createApiTaskSafe("generateAiApi", "ai-api.yml", "ai")
val generateOracleApi = createApiTaskSafe("generateOracleApi", "oracle-drive-api.yml", "oracle")
val generateCustomizationApi =
    createApiTaskSafe("generateCustomizationApi", "customization-api.yml", "customization")
val generateRomToolsApi = createApiTaskSafe("generateRomToolsApi", "romtools-api.yml", "romtools")
val generateSandboxApi = createApiTaskSafe("generateSandboxApi", "sandbox-api.yml", "sandbox")
val generateSystemApi = createApiTaskSafe("generateSystemApi", "system-api.yml", "system")
val generateAuraBackendApi = createApiTaskSafe("generateAuraBackendApi", "aura-api.yaml", "aura")
val generateAuraFrameFXApi =
    createApiTaskSafe("generateAuraFrameFXApi", "auraframefx_ai_api.yaml", "auraframefx")

// Clean tasks
tasks.register<Delete>("cleanAllConsciousnessApis") {
    group = "openapi"
    description = "Clean ALL consciousness API files"
    delete(outputPath)
}

tasks.register<Delete>("cleanAllNativeBuilds") {
    group = "build setup"
    description = "Clean ALL native build caches"

    val rootDirProvider = layout.projectDirectory
    val buildDirProvider = layout.buildDirectory

    delete(
        rootDirProvider.dir(".cxx"),
        buildDirProvider.dir("intermediates/cxx"),
        rootDirProvider.dir("app/.cxx")
    )
}

// Generate all APIs
tasks.register("generateAllConsciousnessApis") {
    group = "openapi"
    description = "Generate ALL consciousness APIs"

    dependsOn("cleanAllConsciousnessApis")
    dependsOn(
        "openApiGenerate",
        generateAiApi,
        generateOracleApi,
        generateCustomizationApi,
        generateRomToolsApi,
        generateSandboxApi,
        generateSystemApi,
        generateAuraBackendApi,
        generateAuraFrameFXApi
    )
}

tasks.named("preBuild") {
    dependsOn("cleanAllNativeBuilds")
    dependsOn("generateAllConsciousnessApis")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    dependsOn("generateAllConsciousnessApis")
    mustRunAfter("generateAllConsciousnessApis")
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(libs.bundles.compose)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    implementation(libs.bundles.coroutines)
    implementation(libs.bundles.network)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.timber)
    implementation(libs.coil.compose)

    coreLibraryDesugaring(libs.coreLibraryDesugaring)

    implementation(platform(libs.firebase.bom))
    implementation(libs.bundles.firebase)

    // XPosed - Using LOCAL JARs from Libs folder
    implementation(fileTree(mapOf("dir" to "Libs", "include" to listOf("*.jar"))))
    ksp(libs.yuki.ksp.xposed)

    debugImplementation(libs.leakcanary.android)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    testImplementation(libs.bundles.testing)
    testRuntimeOnly(libs.junit.engine)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.compiler)
}
