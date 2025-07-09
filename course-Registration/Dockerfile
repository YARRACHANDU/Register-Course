# Use official OpenJDK 17 image
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper files and pom.xml first (to cache dependencies)
COPY backend/mvnw .
COPY backend/.mvn .mvn
COPY backend/pom.xml .

# Download dependencies
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY backend/src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Run the Spring Boot app
CMD ["java", "-jar", "target/course-Registration-0.0.1-SNAPSHOT.jar"]
