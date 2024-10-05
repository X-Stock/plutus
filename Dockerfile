FROM container-registry.oracle.com/graalvm/native-image:21-muslib AS builder
WORKDIR /builder
RUN microdnf install findutils
COPY gradle ./gradle
COPY gradlew build.gradle.kts settings.gradle.kts ./
RUN ./gradlew build 2>/dev/null || true
COPY src ./src
RUN ./gradlew nativeCompile -x test

FROM debian:stable-slim
EXPOSE 8080
WORKDIR /app
COPY --from=builder /builder/build/native/nativeCompile/ .
RUN groupadd --gid 1000 plutus \
  && useradd --uid 1000 --gid plutus -M plutus
USER plutus
ENTRYPOINT [ "./plutus" ]