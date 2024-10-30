FROM gradle:jdk21 AS builder
WORKDIR /builder
COPY build.gradle.kts settings.gradle.kts ./
RUN gradle build 2>/dev/null || true
COPY src ./src
RUN gradle build

FROM bellsoft/liberica-runtime-container:jre-21-crac-slim-musl AS optimizer
WORKDIR /builder
COPY --from=builder /builder/build/libs/*.jar plutus.jar
RUN java -Djarmode=tools -jar plutus.jar extract --layers --destination extracted

FROM bellsoft/liberica-runtime-container:jre-21-crac-slim-musl
EXPOSE 8080
WORKDIR /app
COPY --from=optimizer /builder/extracted/dependencies/ ./
COPY --from=optimizer /builder/extracted/spring-boot-loader/ ./
COPY --from=optimizer /builder/extracted/snapshot-dependencies/ ./
COPY --from=optimizer /builder/extracted/application/ ./
RUN addgroup -g 1000 plutus  \
    && adduser -u 1000 -G plutus -D -H plutus
USER plutus
ENTRYPOINT ["java","-jar","./plutus.jar"]