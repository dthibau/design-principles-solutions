FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/*.jar /app/product-service.jar
CMD ["java", "-Xmx200m", "-jar", "/app/product-service.jar"]

EXPOSE 8888
