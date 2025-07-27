# Stop all Gradle daemons
Write-Host "Stopping Gradle daemons..." -ForegroundColor Cyan
try { & .\\gradlew --stop } catch { Write-Host "No Gradle daemons running" }

# Clean project directories
$dirsToClean = @(
    "\.gradle",
    "\build",
    "\app\build",
    "\buildSrc\build",
    "\buildSrc\.gradle",
    "\buildSrc\buildSrc"
)

Write-Host "`nCleaning project directories..." -ForegroundColor Cyan
foreach ($dir in $dirsToClean) {
    $fullPath = Join-Path -Path $PSScriptRoot -ChildPath $dir.TrimStart("\")
    if (Test-Path $fullPath) {
        Write-Host "Removing $fullPath"
        Remove-Item -Path $fullPath -Recurse -Force -ErrorAction SilentlyContinue
    }
}

# Clean Gradle caches
$gradleUserHome = if ($env:GRADLE_USER_HOME) { $env:GRADLE_USER_HOME } else { "$env:USERPROFILE\.gradle" }
$cacheDirs = @(
    "caches",
    "daemon",
    "workers",
    "kotlin-dsl",
    "kotlin",
    "wrapper"
)

Write-Host "`nCleaning Gradle caches..." -ForegroundColor Cyan
foreach ($cache in $cacheDirs) {
    $cachePath = Join-Path -Path $gradleUserHome -ChildPath $cache
    if (Test-Path $cachePath) {
        Write-Host "Removing $cachePath"
        Remove-Item -Path $cachePath -Recurse -Force -ErrorAction SilentlyContinue
    }
}

# Clean IDE files
Write-Host "`nCleaning IDE files..." -ForegroundColor Cyan
$ideFiles = @(
    "\.idea",
    "*.iml",
    "app\*.iml"
)

foreach ($file in $ideFiles) {
    $fullPath = Join-Path -Path $PSScriptRoot -ChildPath $file.TrimStart("\")
    Get-ChildItem -Path $fullPath -Recurse -Force -ErrorAction SilentlyContinue | Remove-Item -Recurse -Force -ErrorAction SilentlyContinue
}

Write-Host "`nCleanup complete!" -ForegroundColor Green
Write-Host "`nNext steps:" -ForegroundColor Yellow
Write-Host "1. Close all IDEs"
Write-Host "2. Run: .\\gradlew --refresh-dependencies clean build" -ForegroundColor Cyan
