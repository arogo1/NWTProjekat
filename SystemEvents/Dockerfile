FROM openjdk:8-alpine
ADD target/docker-system-events.jar docker-system-events.jar
EXPOSE 8010
ENTRYPOINT [ "java", "-jar", "docker-system-events.jar" ]