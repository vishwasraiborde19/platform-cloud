FROM openjdk:17-alpine
LABEL authors="vishwas"
COPY target/platform-config-server.jar platform-config-server.jar
ENTRYPOINT ["java","-jar", "platform-config-serve.jar"]
EXPOSE 9001