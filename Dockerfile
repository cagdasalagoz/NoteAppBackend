FROM openjdk:8-jdk-alpine
MAINTAINER cagdasalagoz@gmail.com

COPY ./build/libs/note-service-0.0.1-SNAPSHOT.jar /usr/src/note-service/

CMD ["java","-jar","/usr/src/note-service/note-service-0.0.1-SNAPSHOT.jar"]