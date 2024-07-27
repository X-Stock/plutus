FROM container-registry.oracle.com/graalvm/native-image:21 AS builder
RUN <<EOF
    microdnf update && microdnf install findutils unzip zip
    curl -s "https://get.sdkman.io" | bash
    source "$HOME/.sdkman/bin/sdkman-init.sh"
    sdk install gradle
EOF
ENV PATH="$PATH:/root/.sdkman/candidates/gradle/current/bin"
WORKDIR /builder
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle nativeCompile

FROM debian:stable-slim
EXPOSE 8080
WORKDIR /app
COPY --from=builder /builder/build/native/nativeCompile/ .
ENTRYPOINT [ "./plutus" ]