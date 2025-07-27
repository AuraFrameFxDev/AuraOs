# Clean Kotlin-specific caches
Write-Host "Cleaning Kotlin caches..."

# Stop any running Gradle daemons
try {
    & .\gradlew --stop
} catch {
    Write-Host "No Gradle daemons to stop"
}

# Remove build directories
Remove-Item -Recurse -Force -ErrorAction SilentlyContinue -Path .gradle, build, buildSrc\build

# Remove Kotlin-specific caches
$gradleCache = "$env:USERPROFILE\.gradle"
$kotlinCaches = @(
    "caches\modules-2\metadata-2.*",
    "caches\jars-*",
    "caches\kotlin*",
    "caches\transforms-*\*kotlin*",
    "caches\transforms-*\*Kotlin*",
    "workers"
)

foreach ($cache in $kotlinCaches) {
    $path = Join-Path $gradleCache $cache
    if (Test-Path $path) {
        Write-Host "Removing $path"
        Remove-Item -Recurse -Force -ErrorAction SilentlyContinue -Path $path
    }
}

# Rebuild with clean caches
Write-Host "Rebuilding with clean caches..."
& .\gradlew clean build --refresh-dependencies --stacktrace

if ($LASTEXITCODE -ne 0) {
    Write-Host "Build failed with exit code $LASTEXITCODE" -ForegroundColor Red
    exit $LASTEXITCODE
} else {
    Write-Host "Build completed successfully!" -ForegroundColor Green
}

Read-Host "Press Enter to exit"
