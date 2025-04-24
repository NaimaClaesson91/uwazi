#!/bin/bash

test_runner_image="gcr.io/web-infra/codemod-testrunner:2.1.5_20241016T175004"

echo "Building Shift Docker Image"
docker build . -t shift-image

echo "Starting test-runner"
docker run \
  -ti \
  -w "$PWD" \
  -e CODEMOD_IMAGE=shift-image \
  -v "$PWD":"$PWD" \
  -v /var/run/docker.sock:/var/run/docker.sock \
  $test_runner_image
