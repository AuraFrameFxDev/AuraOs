@echo off
setlocal

cd /d "%~dp0"

echo Building oracle-drive-integration module...
call gradlew.bat :oracle-drive-integration:build --stacktrace

if %ERRORLEVEL% NEQ 0 (
    echo Build failed with error code %ERRORLEVEL%
    pause
    exit /b %ERRORLEVEL%
)

echo Build completed successfully!
pause
