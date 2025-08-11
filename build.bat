@echo off
REM ============================================
REM Build script for gui-events-essentials
REM ============================================

if not exist bin mkdir bin

echo Compiling Java files...
javac -d bin src\App.java src\swing\SwingTracker.java src\awt\AwtTracker.java
if %ERRORLEVEL% neq 0 (
  echo.
  echo Compilation FAILED.
  pause
  exit /b %ERRORLEVEL%
)

echo.
echo Compilation SUCCESSFUL.
echo.
echo Run Swing version:
echo   java -cp bin src.App swing "Nasim Bayati"
echo Run AWT version:
echo   java -cp bin src.App awt "Nasim Bayati"
pause
