package com.xstock.plutus;

import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.api.v1.stock.company.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DatabaseCreationTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void getCompany_createdByDefault() {
        Optional<Company> company = companyRepository.findByTicker("VVS");
        assert company.isPresent();
        assertThat(company.get().getTicker()).isEqualTo("VVS");
    }
}
