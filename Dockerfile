FROM openjdk:17.0.1-jdk-slim-buster

WORKDIR /app
COPY target/storage-service-1.0.0.jar storage-service.jar
EXPOSE 8084

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "storage-service.jar"]
