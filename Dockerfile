FROM gradle:jdk21-graal AS builder
WORKDIR /builder
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src
RUN gradle nativeCompile

FROM debian:stable-slim
EXPOSE 8080
WORKDIR /app
COPY --from=builder /builder/build/native/nativeCompile/ .
RUN groupadd --gid 1000 plutus \
  && useradd --uid 1000 --gid plutus -M plutus
USER plutus
ENTRYPOINT [ "./plutus" ]