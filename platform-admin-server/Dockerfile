FROM openjdk:17-alpine
LABEL authors="vishwas"
COPY target/platform-admin-server.jar platform-admin-server.jar
ENTRYPOINT ["java","-jar", "platform-admin-server.jar"]
EXPOSE 9000