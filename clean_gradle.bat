@echo off
echo Stopping Gradle daemons...
taskkill /F /IM "java.exe" /T 2>nul

echo Cleaning Gradle caches...
if exist "%USERPROFILE%\.gradle\caches\" rmdir /s /q "%USERPROFILE%\.gradle\caches\"
if exist "%USERPROFILE%\.gradle\daemon\" rmdir /s /q "%USERPROFILE%\.gradle\daemon\"
if exist "%USERPROFILE%\.gradle\workers\" rmdir /s /q "%USERPROFILE%\.gradle\workers\"

cd /d %~dp0

if exist ".gradle" rmdir /s /q .gradle
if exist "build" rmdir /s /q build
if exist "buildSrc\build" rmdir /s /q "buildSrc\build"

echo Gradle cleanup complete!
pause
