FROM java:8-jdk

ADD . /app
WORKDIR /app

RUN /app/compile.sh