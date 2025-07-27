# Cleanup script for Gradle and Kotlin caches

# Stop Gradle daemons
try {
    Write-Host "Stopping Gradle daemons..."
    & .\gradlew --stop
} catch {
    Write-Host "No Gradle daemons running"
}

# Remove build directories
$directories = @(
    ".gradle",
    "build",
    "buildSrc/build"
)

foreach ($dir in $directories) {
    if (Test-Path $dir) {
        Write-Host "Removing $dir..."
        Remove-Item -Recurse -Force $dir
    }
}

# Clean Gradle caches
$gradleCache = "$env:USERPROFILE\.gradle"
$cacheDirs = @(
    "caches",
    "daemon",
    "workers"
)

foreach ($cacheDir in $cacheDirs) {
    $path = Join-Path $gradleCache $cacheDir
    if (Test-Path $path) {
        Write-Host "Cleaning $path..."
        Remove-Item -Recurse -Force $path
    }
}

Write-Host "Cleanup complete!" -ForegroundColor Green
