#!/bin/bash
. ~/.nvm/nvm.sh
. ~/.profile
. ~/.bashrc
nvm install v12.16.1
nvm use v12.16.1
npm install -g npm@6.14.5
./mvnw -Pprod verify jib:dockerBuild
docker-compose -f src/main/docker/app.yml up