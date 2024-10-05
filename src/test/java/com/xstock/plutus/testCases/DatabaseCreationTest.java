package com.xstock.plutus.testCases;

import com.xstock.plutus.api.stock.v1.company.Company;
import com.xstock.plutus.api.stock.v1.company.CompanyRepository;
import com.xstock.plutus.config.DatabaseTestcontainers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Import(DatabaseTestcontainers.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DatabaseCreationTest {

    @Autowired
    private CompanyRepository companyRepository;

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.sql.init.mode", () -> "always");
        registry.add("spring.jpa.defer-datasource-initialization", () -> true);
    }

    @Test
    void getCompany_createdByDefault() {
        Optional<Company> company = companyRepository.findByTicker("VVS");
        assert company.isPresent();
        assertThat(company.get().getTicker()).isEqualTo("VVS");
    }
}
