#!/usr/bin/env bash

PIDS=$(ps ax | grep -i 'gameoflife' | grep java | grep -v grep | awk '{print $1}')

if [ -z "$PIDS" ]; then
  echo "There is not any GameOfLife App"
  exit 1
else
  kill -s TERM $PIDS
  echo "GameOfLife App killed by pid: " $PIDS
fi

