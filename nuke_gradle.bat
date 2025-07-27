@echo off
echo [INFO] Stopping Gradle daemons...
call gradlew --stop 2>nul

:: Remove project build directories
rmdir /s /q .gradle 2>nul
rmdir /s /q build 2>nul
rmdir /s /q app\build 2>nul
rmdir /s /q buildSrc\build 2>nul
rmdir /s /q buildSrc\.gradle 2>nul

:: Remove Gradle caches
set GRADLE_USER_HOME=%USERPROFILE%\.gradle
rmdir /s /q "%GRADLE_USER_HOME%\caches" 2>nul
rmdir /s /q "%GRADLE_USER_HOME%\daemon" 2>nul
rmdir /s /q "%GRADLE_USER_HOME%\workers" 2>nul
rmdir /s /q "%GRADLE_USER_HOME%\kotlin-dsl" 2>nul
rmdir /s /q "%GRADLE_USER_HOME%\kotlin" 2>nul

:: Remove IDE files
rmdir /s /q .idea 2>nul
del /s /q *.iml 2>nul
del /s /q app\*.iml 2>nul

echo [INFO] Cleanup complete!
echo [INFO] Next steps:
echo 1. Close all IDEs
echo 2. Run: gradlew --refresh-dependencies clean build
pause
