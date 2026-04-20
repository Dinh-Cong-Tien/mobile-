@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows - Auto-download wrapper
@rem
@rem ##########################################################################

setlocal enabledelayedexpansion

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_HOME=%DIRNAME%

@rem Read wrapper properties
for /f "delims=" %%A in ('findstr distributionUrl "%APP_HOME%gradle\wrapper\gradle-wrapper.properties"') do (
    set DISTRIBUTION_URL=%%A
)

@rem Extract URL from properties line
for /f "tokens=2 delims==" %%A in ("%DISTRIBUTION_URL%") do (
    set GRADLE_DIST_URL=%%A
)

@rem Ensure wrapper directory exists
if not exist "%APP_HOME%gradle\wrapper\" mkdir "%APP_HOME%gradle\wrapper\"

@rem Download gradle-wrapper.jar if it doesn't exist
if not exist "%APP_HOME%gradle\wrapper\gradle-wrapper.jar" (
    echo Downloading Gradle wrapper...
    powershell -Command "& {$ProgressPreference = 'SilentlyContinue'; Invoke-WebRequest -Uri 'https://gradle-distribution.azurewebsites.net/distributions/gradle-9.0.0-bin.zip' -OutFile '%APP_HOME%gradle\wrapper\gradle-9.0.0-bin.zip'; Expand-Archive -Path '%APP_HOME%gradle\wrapper\gradle-9.0.0-bin.zip' -DestinationPath '%APP_HOME%gradle\wrapper\' -Force; Remove-Item '%APP_HOME%gradle\wrapper\gradle-9.0.0-bin.zip'}"
)

@rem Find gradle-wrapper.jar
for /r "%APP_HOME%gradle\wrapper\" %%F in (gradle-wrapper.jar) do (
    set WRAPPER_JAR=%%F
    goto found_wrapper
)

:found_wrapper
if exist "%WRAPPER_JAR%" (
    @rem Find java.exe
    if defined JAVA_HOME (
        set JAVA_EXE=%JAVA_HOME%\bin\java.exe
    ) else (
        for /f %%F in ('where java.exe 2^>nul') do (
            set JAVA_EXE=%%F
        )
    )

    if not exist "%JAVA_EXE%" (
        echo ERROR: JAVA_HOME is not set and no 'java' command found
        exit /b 1
    )

    @rem Execute Gradle
    cd /d "%APP_HOME%"
    "%JAVA_EXE%" -classpath "%WRAPPER_JAR%" org.gradle.wrapper.GradleWrapperMain %*
    exit /b %ERRORLEVEL%
) else (
    echo ERROR: Could not find gradle-wrapper.jar
    exit /b 1
)
