FROM openjdk:17

MAINTAINER "ALTAP"

COPY target/57-spring-boot-docker.jar/ /usr/app/

WORKDIR /usr/app/

EXPOSE 8080

LABEL application="flipkart"

ENTRYPOINT [ "java", "-jar", "57-spring-boot-docker.jar" ]