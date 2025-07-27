# Stop any running Gradle daemons
Write-Host "Stopping Gradle daemons..."
& .\gradlew --stop

# Clean build directories
Write-Host "Cleaning build directories..."
Remove-Item -Recurse -Force .\.gradle, \.idea, build, buildSrc\build, app\build -ErrorAction SilentlyContinue

# Clean Gradle caches
Write-Host "Cleaning Gradle caches..."
Remove-Item -Recurse -Force $env:USERPROFILE\.gradle\caches\* -Exclude "*.lock" -ErrorAction SilentlyContinue
Remove-Item -Recurse -Force $env:USERPROFILE\.gradle\daemon -ErrorAction SilentlyContinue
Remove-Item -Recurse -Force $env:USERPROFILE\.gradle\workers -ErrorAction SilentlyContinue

# Delete .gradle directory and regenerate
Remove-Item -Recurse -Force .gradle -ErrorAction SilentlyContinue

Write-Host "Cleanup complete. Please run 'gradle wrapper --gradle-version 8.14.3' to regenerate the wrapper."
