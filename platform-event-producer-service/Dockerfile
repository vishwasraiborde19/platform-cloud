FROM openjdk:17-alpine
LABEL authors="vishwas"
COPY targetplatform-event-producer-service.jar platform-event-producer-service.jar
ENTRYPOINT ["java","-jar", "platform-event-producer-service.jar"]
EXPOSE 6000