FROM ubuntu:latest AS build

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

COPY . .

RUN mvn clean install

FROM openjdk:17-jdk-slim

ENV APP_PROFILE=prod
ENV CLIENT_ID=myclientid
ENV CLIENT_SECRET=myclientsecret
ENV JWT_SECRET=myjwtsecret
ENV JWT_DURATION=86400
ENV CORS_ORIGINS=http://localhost:3000,http://localhost:5173

EXPOSE 8080

COPY --from=build /target/deploy_render-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]