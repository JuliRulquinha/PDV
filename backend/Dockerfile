# ====== Stage 1: Build the application ======
FROM maven:3.9.9-eclipse-temurin-21 AS builder

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies (cached for faster rebuilds)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build the JAR
COPY src ./src
RUN mvn clean package -DskipTests

# ====== Stage 2: Create a lightweight runtime image ======
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/pdv-0.0.1-SNAPSHOT.jar app.jar

# Set environment variables
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Expose the port your app runs on
EXPOSE 8080

# Start the Spring Boot app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
