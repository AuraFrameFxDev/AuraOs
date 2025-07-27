# Script to download and verify Gradle distribution
$ErrorActionPreference = "Stop"

# Gradle version and download URLs
$gradleVersion = "8.1.1"
$gradleZip = "gradle-${gradleVersion}-bin.zip"
$gradleUrl = "https://services.gradle.org/distributions/${gradleZip}"
$gradleSha256 = "e111cb994ea7d658c021c5a98b9dd2fe07b853b644297b5b8b16eb167ac3b25e"

# Function to get file hash
function Get-FileHash256($file) {
    $hash = Get-FileHash -Algorithm SHA256 -Path $file
    return $hash.Hash.ToLower()
}

# Clean up any existing files
if (Test-Path $gradleZip) {
    Remove-Item $gradleZip -Force
}

# Download Gradle
Write-Host "Downloading Gradle $gradleVersion..."
try {
    Invoke-WebRequest -Uri $gradleUrl -OutFile $gradleZip -UseBasicParsing
    Write-Host "Download completed." -ForegroundColor Green
} catch {
    Write-Host "Failed to download Gradle: $_" -ForegroundColor Red
    exit 1
}

# Verify checksum
Write-Host "Verifying checksum..."
$actualHash = Get-FileHash256 $gradleZip

if ($actualHash -ne $gradleSha256) {
    Write-Host "Checksum verification failed!" -ForegroundColor Red
    Write-Host "Expected: $gradleSha256"
    Write-Host "Actual:   $actualHash"
    Remove-Item $gradleZip -Force
    exit 1
}

Write-Host "Checksum verified successfully!" -ForegroundColor Green
Write-Host "File saved as: $(Resolve-Path $gradleZip)"
