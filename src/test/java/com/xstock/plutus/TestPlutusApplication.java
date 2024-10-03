package com.xstock.plutus;

import com.xstock.plutus.config.DatabaseTestcontainers;
import org.springframework.boot.SpringApplication;

class TestPlutusApplication {

    public static void main(String[] args) {
        SpringApplication.from(PlutusApplication::main)
                .with(DatabaseTestcontainers.class)
                .run(args);
    }
}
