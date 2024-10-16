package com.xstock.plutus.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class DatabaseTestcontainers {
    private static final DockerImageName timescaleImage = DockerImageName
            .parse("timescale/timescaledb:latest-pg17")
            .asCompatibleSubstituteFor("postgres");

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> timescaleContainer() {
        return new PostgreSQLContainer<>(timescaleImage);
    }
}
