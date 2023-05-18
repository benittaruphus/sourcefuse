FROM maven:3.8.3-adoptopenjdk-8 as build


COPY . /sourceFuse
WORKDIR /sourceFuse
RUN mvn package spring-boot:repackage -DskipTests

FROM openjdk:8-jre-alpine
COPY --from=build /sourceFuse/target/sourcefuse-0.0.1-SNAPSHOT.jar /opt/app/sourceFuse/target/sourcefuse-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app/sourceFuse/target

CMD "java" "-jar" "sourcefuse-0.0.1-SNAPSHOT.jar"