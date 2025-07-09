# Use a base OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the .jar file from the target folder
COPY target/course-Registration-0.0.1-SNAPSHOT.jar app.jar

# Set environment port (Render uses this)
ENV PORT=8080
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
