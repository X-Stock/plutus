package com.xstock.plutus.v1.company;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyService implements CommonService<Company> {
    private final CompanyRepository companyRepository;

    @Override
    public Company getByTicker(String ticker) {
        Optional<Company> company = companyRepository.findByTicker(ticker);
        return company.orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Iterable<Company> getAll(Pageable pageable) {
        Page<Company> companies = companyRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "ticker")))
        );
        if (companies.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return companies.getContent();
    }
}
