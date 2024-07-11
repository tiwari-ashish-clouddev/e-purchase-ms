FROM openjdk:21-jdk-slim

LABEL authors="Ashish R. Tiwari"
WORKDIR /app
COPY target/product-module.jar /app/product-module.jar

EXPOSE 8080

ENTRYPOINT ["java","-Dspring.profiles.active=uat","-jar","product-module.jar"]