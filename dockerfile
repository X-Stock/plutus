FROM container-registry.oracle.com/graalvm/native-image:21 AS builder

ARG GRADLE_VERSION=8.9
RUN <<EOF
microdnf install findutils unzip
curl -L -o gradle.zip "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
unzip -d /gradle gradle.zip
rm gradle.zip
EOF

ENV PATH=$PATH:/gradle/gradle-${GRADLE_VERSION}/bin

WORKDIR /builder
COPY build.gradle settings.gradle ./
COPY src ./src
RUN  gradle nativeCompile


FROM alpine:latest
RUN apk upgrade && apk add gcompat
EXPOSE 8080
WORKDIR /app
COPY --from=builder /builder/build/native/nativeCompile/ .
ENTRYPOINT [ "./plutus" ]