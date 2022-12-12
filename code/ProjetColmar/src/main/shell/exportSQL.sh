#!/bin/bash
  echo "program launch"
  if [ $# -eq 3]
  then
    mysqldump -u "$1" -p "$2" fprojectcolmar > "$3"
  fi
  else
  then
    exit -1
  fi
