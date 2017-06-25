#!/bin/bash

# Check if we have an extra parameter
if [ $# -eq 0 ]; then
    echo "Your command line contains $# arguments"
    echo "    USAGE: $0 <source_code.kt> <extra_parameters>..."
    echo ""
    echo "More info about Kotlin compiling:"
    echo "    https://kotlinlang.org/docs/tutorials/command-line.html"
    exit 1
fi

FILE1=$1
# Check if it is a script file.
EXTENSION="${FILE1##*.}"
if [ $EXTENSION == 'kts' ]; then
  echo "Running Script..."
  kotlinc -script $FILE1 ${@:2}
  exit 0
elif [ $EXTENSION != 'kt' ]; then
  echo "Unknown file extension, valids are: .kt and .kts"
  exit 2
fi

# Compile.
echo "Compiling ..."
OUTPUT="${FILE1%.*}.jar"
kotlinc $FILE1 -include-runtime -d $OUTPUT

echo ""
echo "Running program..."
kotlin $OUTPUT ${@:2}