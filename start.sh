#!/bin/bash

if [[ $# < 2 ]] ; then
    echo "You have to pass two params"
    echo "1 - git username with access to the forked repos"
    echo "2 - git password of that user"
    echo "Example: ./start.sh user pass"
    exit 0
fi

export PIPELINE_GIT_USERNAME="${1}"
export PIPELINE_GIT_PASSWORD="${2}"

docker-compose build
docker-compose up -d
