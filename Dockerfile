#-- as root user , it is very risky in prod --------
# ----Build Stage -----------
FROM maven:3.9-eclipse-temurin-21 AS stage1
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src /.src
RUN mvn clean package -DskipTests



# -----Runtime stage -------
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=stage1 /build/target/Order-Service.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
