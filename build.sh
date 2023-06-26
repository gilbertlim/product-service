#!/bin/bash

REPOSITORY=9ilbert
SERVICE=product
TYPE=vanila
VERSION=0.0

./gradlew build -x test
docker run --privileged --rm tonistiigi/binfmt --install all
docker buildx rm multiarch-builder
docker buildx create --name multiarch-builder default --use
docker buildx build --platform linux/amd64,linux/arm64 -t $REPOSITORY/$SERVICE:$TYPE-$VERSION . --push