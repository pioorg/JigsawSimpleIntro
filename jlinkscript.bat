@echo off

rmdir /s /q target
rmdir /s /q utils\target\
cd utils
mkdir target\classes
dir /s /B src\*.java > files-to-compile
javac -d target\classes @files-to-compile
del files-to-compile
jar --create --file target\utils.jar -C target\classes\ .
tree /f target
cd ..
mkdir target\classes
dir /s /B src\*.java > files-to-compile
javac --module-path utils\target\utils.jar -d target\classes @files-to-compile
del files-to-compile
jar --create --file target\app.jar --main-class org.company.modularApp.App -C target\classes\ .
echo %time%
java -Xshare:off --module-path target\app.jar;utils\target\utils.jar --module org.company.modularApp
echo %time%
tree /f target
rmdir /s /q %tmp%\linked
jlink --module-path target\app.jar;utils\target\utils.jar --add-modules org.company.modularApp --output %tmp%\linked
echo "Now let's examine the image"
tree /tmp/linked
%tmp%\linked\bin\java --list-modules
echo %time%
%tmp%\linked\bin\java -Xshare:off --module org.company.modularApp
echo %time%
