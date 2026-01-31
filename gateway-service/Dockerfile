FROM maven:3.9.6-eclipse-temurin-21 as build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# etapa 2 runtime

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
    
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]