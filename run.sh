#!/usr/bin/env bash

java -cp ./build:./lib/amqp-client-4.0.2.jar:./lib/json-20170516.jar:./lib/slf4j-api-1.7.25.jar:./lib/slf4j-simple-1.7.25.jar EventReceiver.Main