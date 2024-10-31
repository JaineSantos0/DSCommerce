# Etapa de build
FROM ubuntu:latest AS build

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY . .

RUN mvn clean install

# Etapa final
FROM openjdk:17-jdk-slim

ENV APP_PROFILE=prod
ENV CLIENT_ID=myclientid
ENV CLIENT_SECRET=myclientsecret
ENV JWT_SECRET=myjwtsecret
ENV JWT_DURATION=86400
ENV CORS_ORIGINS=http://localhost:3000,http://localhost:5173
ENV DB_URL=jdbc:postgres://dpg-csh5pabv2p9s73d29450-a:5432/dscommerce_xgcj

EXPOSE 8080

COPY --from=build /app/target/dscommerce_deploy.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]