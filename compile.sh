#!/usr/bin/env bash

rm -rf /app/var/*
rm -rf /app/out/*

cd /app/src
find -name "*.java" > /app/var/sources.txt

javac -d /app/out -cp /app/jar/amqp-client-4.0.2.jar:/app/jar/json-20170516.jar:/app/jar/slf4j-api-1.7.25.jar:/app/jar/slf4j-simple-1.7.25.jar @/app/var/sources.txt


