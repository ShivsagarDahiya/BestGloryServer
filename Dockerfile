# -----------------------------
# Stage 1: Build the application
# -----------------------------
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies first (to leverage Docker cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the jar
COPY src ./src
RUN mvn clean package -DskipTests

# -----------------------------
# Stage 2: Run the application
# -----------------------------
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Use Render's dynamic PORT environment variable
EXPOSE 8080
ENV PORT=8080

ENTRYPOINT ["java","-jar","app.jar"]
