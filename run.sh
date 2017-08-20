#!/usr/bin/env bash

java -cp ./build:./lib/joda-time-2.4.jar:./lib/commons-codec-1.10.jar:./lib/commons-logging-1.1.2.jar:./lib/amqp-client-4.0.2.jar:./lib/org.apache.commons.httpclient.jar:./lib/json-20170516.jar:./lib/slf4j-api-1.7.25.jar:./lib/slf4j-simple-1.7.25.jar EventReceiver.Main $1 $2 $3 $4 $5