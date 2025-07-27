# Stop any running Gradle daemons
gradle --stop

# Clean project build directories
Remove-Item -Recurse -Force .\.gradle, \.idea, \build, \app\build, \buildSrc\build -ErrorAction SilentlyContinue

# Clean Gradle caches
$gradleUserHome = if ($env:GRADLE_USER_HOME) { $env:GRADLE_USER_HOME } else { "$env:USERPROFILE\.gradle" }
$caches = @(
    "$gradleUserHome\caches",
    "$gradleUserHome\daemon",
    "$gradleUserHome\workers",
    "$gradleUserHome\kotlin-dsl",
    "$gradleUserHome\kotlin"
)

foreach ($cache in $caches) {
    if (Test-Path $cache) {
        Write-Host "Removing $cache"
        Remove-Item -Recurse -Force $cache -ErrorAction SilentlyContinue
    }
}

Write-Host "Gradle caches cleaned successfully!" -ForegroundColor Green
Write-Host "Now run: .\gradlew --stop && .\gradlew clean build --refresh-dependencies" -ForegroundColor Yellow
