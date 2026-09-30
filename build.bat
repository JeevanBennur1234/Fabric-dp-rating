@echo off
setlocal enabledelayedexpansion

cd /d "%~dp0"

echo ============================================================
echo   Building Fabric DP Rating Pro
echo ============================================================

:: 1. Locate javac and jar tools
set JAVAC=javac
set JAR_TOOL=jar

where javac >nul 2>nul
if %errorlevel% neq 0 (
    if defined JAVA_HOME (
        if exist "%JAVA_HOME%\bin\javac.exe" (
            set JAVAC="%JAVA_HOME%\bin\javac.exe"
            set JAR_TOOL="%JAVA_HOME%\bin\jar.exe"
            goto :found_java
        )
    )
    for /d %%D in ("C:\Program Files\Java\jdk*") do (
        if exist "%%D\bin\javac.exe" (
            set JAVAC="%%D\bin\javac.exe"
            set JAR_TOOL="%%D\bin\jar.exe"
            goto :found_java
        )
    )
    echo ERROR: javac was not found. Please install JDK 8 or higher and add to PATH or set JAVA_HOME.
    pause
    exit /b 1
)


:found_java
echo Using Java compiler: %JAVAC%

set CP=src\JARS\h2-1.4.200.jar;src\JARS\ojdbc14.jar;src\JARS\rs2xml.jar;src\JARS\hamcrest-core-1.3.jar;src\JARS\imgscalr-lib-4.2.jar;src\JARS\jcommon-1.0.23.jar;src\JARS\jfreechart-1.0.19.jar;src\JARS\jfreechart-1.0.19-experimental.jar;src\JARS\jfreechart-1.0.19-swt.jar;src\JARS\jfreesvg-2.0.jar;src\JARS\junit-4.11.jar;src\JARS\orsoncharts-1.4-eval-nofx.jar;src\JARS\orsonpdf-1.6-eval.jar;src\JARS\servlet.jar;src\JARS\swtgraphics2d.jar

echo [1/5] Cleaning build and dist folders...
if exist build rmdir /s /q build
mkdir build\classes

if not exist dist mkdir dist
if not exist dist\lib mkdir dist\lib

echo [2/5] Compiling Java sources (Target: Java 8)...
%JAVAC% -source 1.8 -target 1.8 -cp "%CP%" -d build\classes src\dprating\*.java 2>nul
if %errorlevel% neq 0 (
    echo Retrying standard compilation...
    %JAVAC% -cp "%CP%" -d build\classes src\dprating\*.java
    if errorlevel 1 (
        echo COMPILE FAILED.
        pause
        exit /b 1
    )
)

echo [3/5] Copying application resources...
if exist src\Replica xcopy /s /q /y src\Replica build\classes\Replica\ >nul
if exist src\ui xcopy /s /q /y src\ui build\classes\ui\ >nul
copy /y src\*.jpg build\classes\ >nul 2>nul
copy /y src\*.gif build\classes\ >nul 2>nul
copy /y src\*.png build\classes\ >nul 2>nul

echo [4/5] Copying library dependencies to dist\lib...
copy /y src\JARS\*.jar dist\lib\ >nul

echo [5/5] Creating executable JAR (dist\DPRating.jar)...
(
echo Manifest-Version: 1.0
echo Main-Class: dprating.DPRating
echo Class-Path: lib/h2-1.4.200.jar lib/ojdbc14.jar lib/rs2xml.jar lib/hamcrest-core-1.3.jar lib/imgscalr-lib-4.2.jar lib/jcommon-1.0.23.jar lib/jfreechart-1.0.19.jar lib/jfreechart-1.0.19-experimental.jar lib/jfreechart-1.0.19-swt.jar lib/jfreesvg-2.0.jar lib/junit-4.11.jar lib/orsoncharts-1.4-eval-nofx.jar lib/orsonpdf-1.6-eval.jar lib/servlet.jar lib/swtgraphics2d.jar
echo.
) > build\manifest_dist.mf

%JAR_TOOL% cfm dist\DPRating.jar build\manifest_dist.mf -C build\classes .
if errorlevel 1 (
    echo JAR CREATION FAILED.
    pause
    exit /b 1
)

echo.
echo ============================================================
echo   BUILD SUCCESSFUL!
echo   Output: dist\DPRating.jar
echo   Dependencies: dist\lib\
echo ============================================================

