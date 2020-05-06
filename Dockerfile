# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine
LABEL maintainer="Egor Avilov <egoravilov99@mail.ru>"
# Add a volume pointing to /tmp
VOLUME /tmp
# Make port available to the world outside this container
EXPOSE 8080
# The application's jar file
ARG JAR_FILE=/web/target/web-1.0-SNAPSHOT.jar
# Add the application's jar to the container
ADD ${JAR_FILE} eastory.jar
ENV JAVA_OPTS="-Xms128m -Xmx128m"
ENV SPRING_PROFILES_ACTIVE=native
# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eastory.jar"]