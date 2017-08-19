#!/usr/bin/env bash

docker build -t atp:event-receiver-for-tests .

docker run -d --name rabbitmq-for-tests -p="15672:5672" -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password rabbitmq
docker run -d --name user-service -p="8001:80" szym1991/fakehttpserver:1.0.0
docker run -d --name event-receiver-for-tests atp:event-receiver-for-tests /app/run.sh localhost 15672 user password events

# todo: improve that
sleep 10

docker run atp:event-receiver-for-tests ant test-integration
TEST_COMMAND_RESULT=$?

docker stop rabbitmq-for-tests
docker stop user-service
docker stop event-receiver-for-tests

docker rm rabbitmq-for-tests
docker rm user-service
docker rm event-receiver-for-tests

exit $TEST_COMMAND_RESULT