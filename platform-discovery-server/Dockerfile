FROM openjdk:17-alpine
LABEL authors="vishwas"
COPY target/platform-discovery-server.jar platform-discovery-server.jar
ENTRYPOINT ["java","-jar", "platform-discovery-server.jar"]
EXPOSE 8761