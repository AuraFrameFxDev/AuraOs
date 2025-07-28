@echo off
setlocal enabledelayedexpansion

REM Set Java 24 as the default for this batch file
set JAVA_HOME=C:\Program Files\Java\jdk-24.0.2
set PATH=!JAVA_HOME!\bin;%PATH%

REM Run the Gradle wrapper with the provided arguments
call gradlew.bat %*
