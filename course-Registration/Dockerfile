# Use OpenJDK 17
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper and config
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Preload dependencies
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy the rest of the project
COPY src ./src

# Package the app
RUN ./mvnw clean package -DskipTests

# Run the JAR
CMD ["java", "-jar", "target/course-Registration-0.0.1-SNAPSHOT.jar"]
