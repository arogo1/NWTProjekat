FROM openjdk:8-alpine
ADD target/docker-inquiry.jar docker-inquiry.jar
EXPOSE 8000
ENTRYPOINT [ "java", "-jar", "docker-inquiry.jar" ]