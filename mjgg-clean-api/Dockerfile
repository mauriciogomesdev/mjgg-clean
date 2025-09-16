FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
RUN apk add --no-cache postgresql-client bash
COPY target/mjgg-clean-api-1.0.0.jar app.jar
CMD ["java", "-jar", "app.jar"]