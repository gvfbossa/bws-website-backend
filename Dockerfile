FROM openjdk:17-jdk-slim

WORKDIR /src

COPY target/bws-site-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]