@ECHO OFF
setlocal

set MAVEN_PROJECTBASEDIR=%MAVEN_BASEDIR%
if not "%MAVEN_PROJECTBASEDIR%"=="" goto endDetectBaseDir

set EXEC_DIR=%CD%
set WDIR=%EXEC_DIR%
:findBaseDir
if exist "%WDIR%\pom.xml" goto baseDirFound
cd ..
if "%WDIR%"=="%CD%" goto baseDirNotFound
set WDIR=%CD%
goto findBaseDir

:baseDirFound
set MAVEN_PROJECTBASEDIR=%WDIR%
cd "%EXEC_DIR%"
goto endDetectBaseDir

:baseDirNotFound
set MAVEN_PROJECTBASEDIR=%EXEC_DIR%
cd "%EXEC_DIR%"

:endDetectBaseDir

set WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"
set WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain

set DOWNLOAD_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"

if exist %WRAPPER_JAR% (
  REM Wrapper jar already present
) else (
  if not exist "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper" (
    mkdir "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper"
  )
  powershell -Command "Invoke-WebRequest -OutFile %WRAPPER_JAR% %DOWNLOAD_URL%"
)

set JAVA_EXE=java.exe

%JAVA_EXE% -classpath %WRAPPER_JAR% %WRAPPER_LAUNCHER% %*
