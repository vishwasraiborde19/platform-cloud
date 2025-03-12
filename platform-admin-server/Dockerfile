FROM openjdk:17-alpine
LABEL authors="vishwas"
RUN mkdir -p /vishwas/apps
COPY target/platform-admin-server.jar /vishwas/apps/platform-admin-server.jar
ENTRYPOINT ["java","-jar", "/vishwas/apps/platform-admin-server.jar"]
EXPOSE 9000