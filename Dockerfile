# Multi-stage Dockerfile for a Maven Spring Boot application
# NOTE: adjust JDK/Maven versions to match your project (this example uses Maven + JDK 17)

FROM maven:3.8.7-openjdk-17 AS build
WORKDIR /workspace
# copy everything and build (adjust if you use a different build layout)
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app
# copy jar built in previous stage (adjust jar name pattern if needed)
COPY --from=build /workspace/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]

# If you are using Java 8 or a different packaging, change base images accordingly.
