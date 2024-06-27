FROM openjdk:22-jdk-slim

LABEL authors="Ashish R. Tiwari"
WORKDIR /app
COPY target/product-module.jar /app/product-module.jar

EXPOSE 8081
CMD ["java","-jar","product-module.jar"]