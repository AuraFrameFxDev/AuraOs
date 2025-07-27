@echo off
echo Stopping Gradle daemons...
taskkill /F /IM "java.exe" /T 2>nul

eclecho Cleaning Gradle caches...
if exist "%USERPROFILE%\.gradle\caches\" rmdir /s /q "%USERPROFILE%\.gradle\caches\"
if exist "%USERPROFILE%\.gradle\daemon\" rmdir /s /q "%USERPROFILE%\.gradle\daemon\"
if exist "%USERPROFILE%\.gradle\workers\" rmdir /s /q "%USERPROFILE%\.gradle\workers\"

cd /d %~dp0

if exist ".gradle" rmdir /s /q .gradle
if exist "build" rmdir /s /q build
if exist "buildSrc\build" rmdir /s /q "buildSrc\build"
if exist "oracle-drive-integration\.gradle" rmdir /s /q "oracle-drive-integration\.gradle"
if exist "oracle-drive-integration\build" rmdir /s /q "oracle-drive-integration\build"

echo Rebuilding project...
call gradlew clean build --stacktrace

echo Done!
pause
