# For Java 11,
FROM adoptopenjdk/openjdk15:ubi
MAINTAINER  Xingxiliang
ARG JAR_FILE=springboot_find_weakness-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

# Copy the spring-boot-api-tutorial.jar from the maven stage to the /opt/app directory of the current stage.
COPY target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","springboot_find_weakness-0.0.1-SNAPSHOT.jar"]

# docker build -t xingxiliang/spring_find_weak_server    .