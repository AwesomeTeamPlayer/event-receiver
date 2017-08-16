FROM java:8-jdk

ADD . /app
WORKDIR /app

RUN apt update
RUN apt install -y ant

RUN ant compile