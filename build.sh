#!/bin/bash

REPOSITORY=9ilbert
SERVICE=product
VERSION=0.1

./gradlew build -x test
docker run --privileged --rm tonistiigi/binfmt --install all
docker buildx rm multiarch-builder
docker buildx create --name multiarch-builder default --use
docker buildx build --platform linux/amd64 -t $REPOSITORY/$SERVICE:amd-$VERSION . --push
docker buildx build --platform linux/arm64 -t $REPOSITORY/$SERVICE:arm-$VERSION . --push
docker buildx build --platform linux/amd64,linux/arm64 -t $REPOSITORY/$SERVICE:multiarch-$VERSION . --push