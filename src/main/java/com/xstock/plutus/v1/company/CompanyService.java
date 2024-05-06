package com.xstock.plutus.v1.company;

import com.xstock.plutus.exception.EntityNotFoundException;
import com.xstock.plutus.utils.interfaces.service.SingleResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyService implements SingleResponseService<Company> {
    private final CompanyRepository companyRepository;

    @Override
    public Company getByTicker(String ticker) {
        Optional<Company> company = companyRepository.findByTicker(ticker);
        return company.orElseThrow(() -> new EntityNotFoundException("company by " + ticker));
    }

    public Iterable<Company> getAll() {
        Iterable<Company> companies = companyRepository.findAll();
        if (!companies.iterator().hasNext()) {
            throw new EntityNotFoundException("all companies");
        }
        return companies;
    }
}
