#!/bin/bash

# Check if we have an extra parameter
if [ $# -eq 0 ]; then
    echo "Your command line contains $# arguments"
    echo "    USAGE: $0 <source_code.kt>"
    echo ""
    echo "More info about Kotlin compiling:"
    echo "    https://kotlinlang.org/docs/tutorials/command-line.html"
    exit 1
fi

OUTPUT=${1%.*}.jar
echo "Compiling ..."
kotlinc $1 -include-runtime -d $OUTPUT

echo ""
echo "Running..."
kotlin $OUTPUT