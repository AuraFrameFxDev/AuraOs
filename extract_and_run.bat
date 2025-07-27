@echo off
setlocal enabledelayedexpansion

echo Extracting Gradle...
"C:\Windows\System32\tar.exe" -xf gradle-8.1.1-bin.zip

if not exist gradle-8.1.1 (
    echo Failed to extract Gradle
    exit /b 1
)

echo Running Gradle...
call gradle-8.1.1\bin\gradle.bat --version

if %ERRORLEVEL% neq 0 (
    echo Gradle execution failed
    exit /b 1
)

echo Gradle is working correctly!
pause
