FROM openjdk:8-alpine
ADD target/docker-zuul.jar docker-zuul.jar
EXPOSE 8090
ENTRYPOINT [ "java", "-jar", "docker-zuul.jar" ]