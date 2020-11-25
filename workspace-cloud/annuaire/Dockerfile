FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./annuaire.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/annuaire.jar"]

EXPOSE 1111
