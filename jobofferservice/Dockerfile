#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jre-slim
LABEL maintainer="j.kubica.ledzion@gmail.com"
VOLUME /tmp
COPY --from=build /home/app/target/job-offer-service-0.0.1-SNAPSHOT.jar /usr/local/lib/job-offer-service-0.0.1-SNAPSHOT.jar
EXPOSE 8081
# ARG JAR_FILE=target/user-service-0.0.1-SNAPSHOT.jar
# ADD ${JAR_FILE} user-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/local/lib/job-offer-service-0.0.1-SNAPSHOT.jar"]
