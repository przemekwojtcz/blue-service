FROM openjdk:17-alpine
EXPOSE 8080

COPY target/service-blue.jar .

CMD ["java", "-jar", "service-blue.jar"]

