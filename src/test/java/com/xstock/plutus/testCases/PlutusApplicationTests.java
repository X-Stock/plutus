package com.xstock.plutus.testCases;

import com.xstock.plutus.config.DatabaseTestcontainers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(DatabaseTestcontainers.class)
@SpringBootTest
class PlutusApplicationTests {

    @Test
    void contextLoad() {
    }
}
