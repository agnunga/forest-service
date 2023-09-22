# syntax=docker/dockerfile:1
FROM openjdk:11
WORKDIR /
ADD build/libs/forest-service-1.0-SNAPSHOT.jar forest-service.jar
EXPOSE 4567
CMD java -jar forest-service.jar
