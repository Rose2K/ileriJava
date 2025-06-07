FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# Add executable permission to mvnw
RUN chmod +x ./mvnw

RUN ./mvnw package -DskipTests

CMD ["java", "-jar", "target/javaFinal-0.0.1-SNAPSHOT.jar"] 