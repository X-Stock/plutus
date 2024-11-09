FROM gradle:jdk21 AS builder
WORKDIR /builder
COPY build.gradle.kts settings.gradle.kts ./
RUN gradle build 2>/dev/null || true
COPY src ./src
RUN gradle build

FROM bellsoft/liberica-runtime-container:jre-21-cds-slim-musl AS base

FROM base AS optimizer
WORKDIR /builder
COPY --from=builder /builder/build/libs/*.jar plutus.jar
RUN java -Djarmode=tools -jar plutus.jar extract --layers --destination extracted

FROM base
EXPOSE 8080
RUN addgroup --system -g 1000 plutus && adduser --system -u 1000 -G plutus plutus
WORKDIR /app
COPY --from=optimizer --chown=plutus:plutus /builder/extracted/dependencies/ ./
COPY --from=optimizer --chown=plutus:plutus /builder/extracted/spring-boot-loader/ ./
COPY --from=optimizer --chown=plutus:plutus /builder/extracted/snapshot-dependencies/ ./
COPY --from=optimizer --chown=plutus:plutus /builder/extracted/application/ ./
RUN java -XX:ArchiveClassesAtExit=application.jsa  \
    -Dspring.aot.enabled=true \
    -Dspring.context.exit=onRefresh \
    -Dspring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect \
    -Dspring.jpa.properties.hibernate.boot.allow_jdbc_metadata_access=false \
    -Dspring.jpa.hibernate.ddl-auto=none \
    -Dspring.sql.init.mode=never \
    -jar plutus.jar
USER plutus
ENTRYPOINT ["java", "-XX:SharedArchiveFile=application.jsa", "-Dspring.aot.enabled=true", "-jar", "plutus.jar"]