FROM openjdk:17-alpine
LABEL authors="vishwas"
RUN mkdir -p /vishwas/apps
COPY target/lms-learning-mgmt-service.jar /vishwas/apps/lms-learning-mgmt-service.jar
ENTRYPOINT ["java","-jar", "/vishwas/apps/lms-learning-mgmt-service.jar"]
EXPOSE 6003