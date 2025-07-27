# Script to download and run Gradle directly
Write-Host "Setting up Gradle directly..."

# Set Gradle version
$gradleVersion = "8.1.1"
$gradleUrl = "https://services.gradle.org/distributions/gradle-${gradleVersion}-bin.zip"
$gradleZip = "gradle-${gradleVersion}-bin.zip"
$gradleDir = "gradle-${gradleVersion}"

# Download Gradle
Write-Host "Downloading Gradle ${gradleVersion}..."
try {
    Invoke-WebRequest -Uri $gradleUrl -OutFile $gradleZip -ErrorAction Stop
    Write-Host "Download completed successfully." -ForegroundColor Green
} catch {
    Write-Host "Failed to download Gradle: $_" -ForegroundColor Red
    exit 1
}

# Extract Gradle
Write-Host "Extracting Gradle..."
try {
    Expand-Archive -Path $gradleZip -DestinationPath "." -Force -ErrorAction Stop
    Write-Host "Extraction completed successfully." -ForegroundColor Green
} catch {
    Write-Host "Failed to extract Gradle: $_" -ForegroundColor Red
    exit 1
}

# Run Gradle version check
Write-Host "Running Gradle version check..."
& ".\$gradleDir\bin\gradle.bat" --version

if ($LASTEXITCODE -ne 0) {
    Write-Host "Gradle execution failed. Please check the error messages above." -ForegroundColor Red
    exit 1
}

# Run the build
Write-Host "Running Gradle build..."
& ".\$gradleDir\bin\gradle.bat" build --stacktrace --info

if ($LASTEXITCODE -ne 0) {
    Write-Host "Build failed. Please check the error messages above." -ForegroundColor Red
    exit 1
}

Write-Host "Gradle build completed successfully!" -ForegroundColor Green
Write-Host "Press any key to continue..."
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
