#!/usr/bin/env sh
# Unix launcher for the checked-in Gradle wrapper JAR; invoke with `bash ./gradlew` if not executable.
set -eu

APP_HOME=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
exec java -classpath "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
