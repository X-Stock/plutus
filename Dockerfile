FROM gradle:jdk21 AS builder
WORKDIR /builder
COPY build.gradle.kts settings.gradle.kts ./
RUN gradle build 2>/dev/null || true
COPY src ./src
RUN gradle build

FROM eclipse-temurin:21-jre-alpine
EXPOSE 8080
WORKDIR /app
COPY --from=builder /builder/build/libs/*.jar ./plutus.jar
RUN addgroup -g 1000 plutus  \
    && adduser -u 1000 -G plutus -D -H plutus
USER plutus
ENTRYPOINT ["java","-jar","./plutus.jar"]