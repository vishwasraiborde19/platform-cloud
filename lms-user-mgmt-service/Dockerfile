FROM openjdk:17-alpine
LABEL authors="vishwas"
RUN mkdir -p /vishwas/apps
COPY target/lms-user-mgmt-service.jar /vishwas/apps/lms-user-mgmt-service.jar
ENTRYPOINT ["java","-jar", "/vishwas/apps/lms-user-mgmt-service.jar"]
EXPOSE 6001