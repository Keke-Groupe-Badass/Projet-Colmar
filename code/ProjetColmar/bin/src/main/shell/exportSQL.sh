#!/bin/bash
  echo "program launch"
  if [ $# -eq 4]
  then
    mysqldump -u "$1" -p "$2" "$3" > "$4"+"/db.sql"
    #mysqldump -u "utilisateur" -p "mot de passe" "base de donnée" > "chemin"
  fi
  else
  then
    exit -1
  fi
