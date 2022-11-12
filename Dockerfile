FROM openjdk:17-jdk-slim
ARG JAR_FILE=danis-salakheev.jar
EXPOSE 8080
COPY /build/libs/${JAR_FILE} musala-app.jar
ENTRYPOINT ["java", "-jar", "musala-app.jar"]