FROM openjdk:17-alpine
LABEL authors="vishwas"
COPY target/platform-event-consumer-service.jar platform-event-consumer-service.jar
ENTRYPOINT ["java","-jar", "platform-event-consumer-servicer.jar"]
EXPOSE 7001