FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/*.jar /app/config.jar
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

EXPOSE 8888
