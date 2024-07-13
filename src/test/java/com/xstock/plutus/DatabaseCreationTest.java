package com.xstock.plutus;

import com.xstock.plutus.v1.company.Company;
import com.xstock.plutus.v1.company.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class DatabaseCreationTest {
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void getCompany_createdByDefault() {
        Optional<Company> company = companyRepository.findByTicker("VVS");
        assert company.isPresent();
        assertEquals("VVS", company.get().getTicker());
    }
}
