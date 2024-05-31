# First stage: Build the application
FROM maven:3.8.4-eclipse-temurin-21 as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -Dmaven.test.skip=true

# Second stage: Dockerize
FROM eclipse-temurin:21.0.2_13-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/mnsgarage-0.0.1-SNAPSHOT.jar ./mnsgarage.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mnsgarage.jar"]
