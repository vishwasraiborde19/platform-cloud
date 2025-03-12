FROM openjdk:17-alpine
LABEL authors="vishwas"
RUN mkdir -p /vishwas/apps
COPY target/platform-discovery-server.jar /vishwas/apps/platform-discovery-server.jar
ENTRYPOINT ["java","-jar", "/vishwas/apps/platform-discovery-server.jar"]
EXPOSE 8761