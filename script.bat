@echo off

rmdir /s /q target
rmdir /s /q utils\target\
cd utils
mkdir target\classes
dir /s /B src\*.java > files-to-compile
javac --module-path ..\libs\guava-27.1-jre.jar -d target\classes @files-to-compile
del files-to-compile
jar --create --file target\utils.jar -C target\classes\ .
tree /f target
cd ..
mkdir target\classes
dir /s /B src\*.java > files-to-compile
javac --module-path utils\target\utils.jar;libs\guava-27.1-jre.jar -d target\classes @files-to-compile
del files-to-compile
jar --create --file target\app.jar --main-class org.company.modularApp.App -C target\classes\ .
java @java-modules-options  --module-path target\app.jar;utils\target\utils.jar;libs\guava-27.1-jre.jar --module org.company.modularApp
tree /f target