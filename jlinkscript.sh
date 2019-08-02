#!/usr/bin/env bash
set -e
rm -rf target
rm -rf utils/target
cd utils || die "utils not found!"
mkdir -p target/classes
javac -d target/classes $(find src -name "*.java")
jar --create --file target/utils.jar -C target/classes/ .
tree target
cd ..
mkdir -p target/classes
javac --module-path utils/target/utils.jar -d target/classes $(find src -name "*.java")
jar --create --file target/app.jar --main-class org.company.modularApp.App -C target/classes/ .
tree target
time java -Xshare:off --module-path target/app.jar:utils/target/utils.jar --module org.company.modularApp
rm -rf /tmp/linked
jlink --module-path target/app.jar:utils/target/utils.jar --add-modules org.company.modularApp --output /tmp/linked
echo "Now let's examine the image"
tree /tmp/linked
du -h -d 0 /tmp/linked
/tmp/linked/bin/java --list-modules
time /tmp/linked/bin/java -Xshare:off --module org.company.modularApp