#!/usr/bin/env bash
set -e
rm -rf target
rm -rf utils/target
cd utils || die "utils not found!"
mkdir -p target/classes
javac --module-path ../libs/guava-27.1-jre.jar -d target/classes $(find src -name "*.java")
jar --create --file target/utils.jar -C target/classes/ .
tree target
cd ..
mkdir -p target/classes
javac --module-path utils/target/utils.jar:libs/guava-27.1-jre.jar -d target/classes $(find src -name "*.java")
jar --create --file target/app.jar --main-class org.company.modularApp.App -C target/classes/ .
tree target
java --module-path target/app.jar:utils/target/utils.jar:libs/guava-27.1-jre.jar --module org.company.modularApp
