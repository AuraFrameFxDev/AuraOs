# Script to regenerate the Gradle wrapper with the correct configuration
Write-Host "Regenerating Gradle wrapper..."

# Remove existing wrapper files
Remove-Item -Recurse -Force -ErrorAction SilentlyContinue -Path ".gradle", "gradle", "gradlew", "gradlew.bat"

# Download the Gradle wrapper
$gradleVersion = "8.1.1"
$gradleUrl = "https://services.gradle.org/distributions/gradle-${gradleVersion}-bin.zip"
$gradleZip = "gradle-bin.zip"

Write-Host "Downloading Gradle $gradleVersion..."
Invoke-WebRequest -Uri $gradleUrl -OutFile $gradleZip

# Extract Gradle
Write-Host "Extracting Gradle..."
Expand-Archive -Path $gradleZip -DestinationPath "." -Force

# Initialize the wrapper
Write-Host "Initializing Gradle wrapper..."
& ".\gradle-$gradleVersion\bin\gradle.bat" wrapper --gradle-version $gradleVersion --distribution-type bin

# Clean up
del $gradleZip
Remove-Item -Recurse -Force -ErrorAction SilentlyContinue -Path "gradle-$gradleVersion"

Write-Host "Gradle wrapper has been regenerated successfully!" -ForegroundColor Green
Write-Host "You can now run the build using: .\gradlew.bat build"

# Keep the console open
Write-Host "Press any key to continue..."
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
