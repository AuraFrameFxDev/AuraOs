@echo off
setlocal enabledelayedexpansion

:: Set the project root directory
set "PROJECT_ROOT=%~dp0"

:: Change to the project root directory
cd /d "%PROJECT_ROOT%"

echo Building project...

:: Run Gradle build with error handling
call gradlew.bat build --stacktrace --info

if %ERRORLEVEL% NEQ 0 (
    echo Build failed with error code %ERRORLEVEL%
    pause
    exit /b %ERRORLEVEL%
)

echo Build completed successfully!
pause
