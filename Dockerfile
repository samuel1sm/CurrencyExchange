FROM maven:3.6.3-openjdk-14-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B package --file pom.xml -DskipTests

FROM openjdk:14-slim
ARG JAR_FILE=*.jar
COPY --from=build /workspace/target/${JAR_FILE} app.jar
EXPOSE 8080:8080
ENTRYPOINT ["java","-jar","app.jar"]
