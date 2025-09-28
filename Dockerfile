FROM maven:3.8.7-openjdk-17 AS build
WORKDIR /workspace
COPY pom.xml ./
COPY app ./app
RUN mvn -B -f app/pom.xml -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /workspace/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /app/app.jar"]    
