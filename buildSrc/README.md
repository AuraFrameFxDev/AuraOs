# AuraFrameFX Build System

This directory contains the build logic for the AuraFrameFX project, implemented as Gradle plugins. These plugins standardize build configurations across the project and provide reusable build logic.

## Available Plugins

### 1. Base Convention (`auraframefx.base.convention`)
The foundation plugin that sets up common configurations for all modules.

**Applies:**
- Kotlin Android plugin
- Hilt for dependency injection
- Common Android configurations (SDK versions, Java toolchain, etc.)

**Usage:**
```kotlin
plugins {
    id("auraframefx.base.convention")
}
```

### 2. UI Conventions (`auraframefx.ui.conventions`)
Standardizes UI-related configurations including theming, Compose setup, and common UI dependencies.

**Applies:**
- Material Design 3
- Jetpack Compose
- Common UI dependencies (Coil, Navigation, etc.)

**Usage:**
```kotlin
plugins {
    id("auraframefx.ui.conventions")
}
```

### 3. OracleDrive (`auraframefx.oracledrive`)
Configures the OracleDrive module with cloud storage and file handling capabilities.

**Applies:**
- Google Drive API
- File handling utilities
- Background sync configuration

**Usage:**
```kotlin
plugins {
    id("auraframefx.oracledrive")
}
```

### 4. Assistant Jobs (`auraframefx.assistant.jobs`)
Sets up background job processing using WorkManager.

**Applies:**
- WorkManager with Kotlin coroutines
- Hilt integration for dependency injection
- Background task scheduling

**Usage:**
```kotlin
plugins {
    id("auraframefx.assistant.jobs")
}
```

### 5. ROM Tooling (`auraframefx.romtooling`)
Provides tasks for ROM building and management.

**Applies:**
- Custom ROM generation tasks
- ROM signing and validation
- Build type configurations

**Usage:**
```kotlin
plugins {
    id("auraframefx.romtooling")
}
```

## Development

### Adding a New Plugin
1. Create a new Kotlin file in `src/main/kotlin/plugins/`
2. Implement the `Plugin<Project>` interface
3. Register the plugin in `build.gradle.kts` under the `gradlePlugin` block
4. Update the `pluginBundle` configuration if publishing is needed

### Version Management
All versions are managed in the `Versions` object in `build.gradle.kts`. Update versions in this single location.

### Testing Plugins
To test a plugin locally:
1. Apply the plugin in a test module
2. Run `./gradlew :test-module:build`
3. Check for any configuration or dependency resolution issues

## Best Practices
- Keep plugin responsibilities focused and single-purpose
- Document all public APIs and configurations
- Use the `afterEvaluate` block sparingly
- Prefer convention plugins over `subprojects` or `allprojects` blocks
- Keep build logic in buildSrc, not in root build scripts
