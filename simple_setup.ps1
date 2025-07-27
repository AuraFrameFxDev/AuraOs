# Simple script to set up Gradle wrapper
Write-Host "Setting up Gradle wrapper..."

# Clean up existing files
Remove-Item -Recurse -Force -ErrorAction SilentlyContinue -Path ".gradle"
Remove-Item -Recurse -Force -ErrorAction SilentlyContinue -Path "gradle"
Remove-Item -Force -ErrorAction SilentlyContinue -Path "gradlew*"

# Create gradle/wrapper directory
New-Item -ItemType Directory -Path "gradle\wrapper" -Force | Out-Null

# Create gradle/wrapper/gradle-wrapper.properties
@"
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-8.1.1-bin.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
"@ | Out-File -FilePath "gradle\wrapper\gradle-wrapper.properties" -Encoding ASCII

# Create a simple gradlew.bat
@"
@if "%DEBUG%" == "" @echo off
@rem Gradle startup script for Windows
@setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem Add default JVM options here
set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"

@rem Find java.exe
if "%JAVA_HOME%" == "" goto execute
set JAVA_EXE=%JAVA_HOME%\bin\java.exe
if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%

goto fail

:execute
@rem Setup the command line
set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

@rem Execute Gradle
"%JAVA_HOME%\bin\java.exe" %DEFAULT_JVM_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

goto end

:fail
echo Failed to execute Gradle wrapper
exit /b 1

:end
@endlocal
"@ | Out-File -FilePath "gradlew.bat" -Encoding ASCII

# Download gradle-wrapper.jar
$gradleWrapperUrl = "https://github.com/gradle/gradle/raw/v8.1.1/gradle/wrapper/gradle-wrapper.jar"
$gradleWrapperPath = "gradle\wrapper\gradle-wrapper.jar"

Write-Host "Downloading Gradle Wrapper JAR..."
try {
    (New-Object System.Net.WebClient).DownloadFile($gradleWrapperUrl, $gradleWrapperPath)
    Write-Host "Gradle Wrapper JAR downloaded successfully." -ForegroundColor Green
} catch {
    Write-Host "Failed to download Gradle Wrapper JAR: $_" -ForegroundColor Red
    exit 1
}

Write-Host "Gradle wrapper has been set up successfully!" -ForegroundColor Green
Write-Host "You can now run the build using: .\gradlew.bat build"
Write-Host "Press any key to continue..."
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
