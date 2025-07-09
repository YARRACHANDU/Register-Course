FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x mvnw && ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/course-Registration-0.0.1-SNAPSHOT.jar"]
