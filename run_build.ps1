# PowerShell script to run the Gradle build
Write-Host "Starting build process..."

# Set the project root directory
$projectRoot = Split-Path -Parent $MyInvocation.MyCommand.Path

# Change to the project directory
Set-Location -Path $projectRoot

# Run Gradle build with stacktrace and info
& .\gradlew.bat build --stacktrace --info

# Check the exit code
if ($LASTEXITCODE -ne 0) {
    Write-Host "Build failed with exit code $LASTEXITCODE" -ForegroundColor Red
} else {
    Write-Host "Build completed successfully!" -ForegroundColor Green
}

# Keep the console open
Write-Host "Press any key to continue..."
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
