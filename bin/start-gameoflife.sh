#!/usr/bin/env bash

DIMENTION_OF_BOARD=$1
CURRENT_DIR=$(dirname $0)

if [ $# -ne 1 ];
then
        echo "Please give a dimention as a positive integer parameter"
        echo "USAGE: ./start-gameoflife.sh [dimention]"
        exit 1
fi

java -jar $CURRENT_DIR/../lib/gameoflife.jar $DIMENTION_OF_BOARD