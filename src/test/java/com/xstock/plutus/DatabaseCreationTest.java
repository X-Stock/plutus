package com.xstock.plutus;

import com.xstock.plutus.company.Company;
import com.xstock.plutus.company.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class DatabaseCreationTest {
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void createCompany_thenGetName() {
        Company company = new Company();
        company.setTicker("SSI");
        companyRepository.save(company);

        Company company2 = companyRepository.findById(1).orElse(null);
        assert company2 != null;
        assertEquals("SSI", company2.getTicker());
    }
}
