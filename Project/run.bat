@echo off
set "PROJECT_DIR=C:\Users\Тимур\Documents\GitHub\MarketPlaceProject"
cd /d "%PROJECT_DIR%"

mvn compile exec:java

pause