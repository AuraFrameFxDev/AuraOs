# Script to fix Gradle wrapper JAR and verify Java environment
Write-Host "Fixing Gradle wrapper..."

# Verify Java installation
Write-Host "Checking Java installation..."
$javaVersion = (java -version 2>&1) | Out-String
if ($LASTEXITCODE -ne 0) {
    Write-Host "Java is not installed or not in PATH. Please install Java 17 or later." -ForegroundColor Red
    exit 1
}
Write-Host "Java version:" -ForegroundColor Green
$javaVersion

# Download a fresh copy of gradle-wrapper.jar
$gradleVersion = "8.1.1"
$gradleWrapperUrl = "https://github.com/gradle/gradle/raw/v${gradleVersion}/gradle/wrapper/gradle-wrapper.jar"
$gradleWrapperPath = "gradle\wrapper\gradle-wrapper.jar"

Write-Host "Downloading fresh Gradle Wrapper JAR..."
try {
    # Remove existing file if it exists
    Remove-Item -Path $gradleWrapperPath -Force -ErrorAction SilentlyContinue
    
    # Download with progress
    $webClient = New-Object System.Net.WebClient
    $webClient.DownloadFile($gradleWrapperUrl, $gradleWrapperPath)
    
    # Verify file size
    $fileInfo = Get-Item $gradleWrapperPath
    if ($fileInfo.Length -lt 50000) {  # Should be around 60-70KB
        throw "Downloaded file is too small (${$fileInfo.Length} bytes), likely corrupted"
    }
    
    Write-Host "Gradle Wrapper JAR downloaded successfully (${$fileInfo.Length} bytes)" -ForegroundColor Green
} catch {
    Write-Host "Failed to download Gradle Wrapper JAR: $_" -ForegroundColor Red
    exit 1
}

# Verify the wrapper
Write-Host "Verifying Gradle wrapper..."
.\gradlew.bat --version

if ($LASTEXITCODE -ne 0) {
    Write-Host "Gradle wrapper verification failed. Please check the error messages above." -ForegroundColor Red
    exit 1
}

Write-Host "Gradle wrapper has been fixed successfully!" -ForegroundColor Green
Write-Host "You can now run the build using: .\gradlew.bat build"
Write-Host "Press any key to continue..."
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
