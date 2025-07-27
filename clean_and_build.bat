@echo off
echo Cleaning Gradle caches and rebuilding...

echo Stopping Gradle daemons...
call gradlew --stop

rem Clean build directories
if exist .gradle rmdir /s /q .gradle
if exist build rmdir /s /q build
if exist buildSrc\build rmdir /s /q buildSrc\build

rem Delete Gradle caches
echo Removing Gradle caches...
if exist "%USERPROFILE%\.gradle\caches" rmdir /s /q "%USERPROFILE%\.gradle\caches"
if exist "%USERPROFILE%\.gradle\daemon" rmdir /s /q "%USERPROFILE%\.gradle\daemon"
if exist "%USERPROFILE%\.gradle\workers" rmdir /s /q "%USERPROFILE%\.gradle\workers"

rem Rebuild with --refresh-dependencies
echo Rebuilding with clean caches...
call gradlew clean build --refresh-dependencies --stacktrace

if %ERRORLEVEL% NEQ 0 (
    echo Build failed with error code %ERRORLEVEL%
    exit /b %ERRORLEVEL%
)

echo Build completed successfully!
pause
