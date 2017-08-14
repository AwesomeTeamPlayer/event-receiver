#!/usr/bin/env bash

java -cp /app/out:/app/jar/amqp-client-4.0.2.jar:/app/jar/slf4j-api-1.7.25.jar:/app/jar/slf4j-simple-1.7.25.jar EventReceiver.Main