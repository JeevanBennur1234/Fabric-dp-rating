@echo off
setlocal
cd /d %~dp0

set JAVA_CMD=java

where java >nul 2>nul
if %errorlevel% neq 0 (
    if defined JAVA_HOME (
        if exist %JAVA_HOME%\bin\java.exe (
            set JAVA_CMD=%JAVA_HOME%\bin\java.exe
            goto :launch
        )
    )
    for /d %%D in ("C:\Program Files\Java\jdk*" "C:\Program Files\Java\jre*") do (
        if exist "%%D\bin\java.exe" (
            set JAVA_CMD="%%D\bin\java.exe"
            goto :launch
        )
    )
    echo ERROR: Java runtime not found. Please install Java 8 or higher and add to PATH.
    pause
    exit /b 1
)


:launch
if not exist "dist\DPRating.jar" (
    echo [INFO] dist\DPRating.jar not found. Running build.bat first...
    call build.bat
    if errorlevel 1 exit /b 1
)

echo Starting Fabric DP Rating Pro...
%JAVA_CMD% -cp "dist\DPRating.jar;dist\lib\*" dprating.DPRating

