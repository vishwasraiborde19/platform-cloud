FROM openjdk:17-alpine
LABEL authors="vishwas"
COPY target/platform-web-core.jar  platform-web-core.jar
ENTRYPOINT ["java","-jar", "platform-web-core.jar"]
EXPOSE 8080