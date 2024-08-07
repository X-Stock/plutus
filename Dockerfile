FROM gradle:jdk21-graal AS builder
WORKDIR /builder
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle nativeCompile

FROM debian:stable-slim
EXPOSE 8080
WORKDIR /app
COPY --from=builder /builder/build/native/nativeCompile/ .
ENTRYPOINT [ "./plutus" ]