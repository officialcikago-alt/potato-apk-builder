#!/usr/bin/env bash

# ********************************************************************************
# FILE: gradlew (Executable Script)
# PURPOSE: Android build engine ko Linux server par start karna
# [2026-02-06] Code ma bhar bhar ka comment use hona chayya.
# ********************************************************************************

# Is script ka kaam hai sahi Java version check karna aur build process shuru karna
APP_NAME="PotatoStore-Builder"
APP_BASE_NAME=`basename "$0"`

# Terminal par message dikhane ke liye
echo "Bhai, Potato Cloud Build engine start ho raha hai..."

# Gradle ki commands ko server ke environment mein set karna
warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

# Java ki location check ho rahi hai
if [ -n "$JAVA_HOME" ] ; then
    JAVACMD="$JAVA_HOME/bin/java"
else
    JAVACMD="java"
fi

# Agar Java nahi mila toh build fail ho jayegi
if [ ! -x "$JAVACMD" ] ; then
    die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME"
fi

# Build ki main command execute ho rahi hai
# [2026-02-06] Ye line asli compilation trigger karti hai
exec "$JAVACMD" "-Xmx64m" "-Xms64m" -classpath "gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
