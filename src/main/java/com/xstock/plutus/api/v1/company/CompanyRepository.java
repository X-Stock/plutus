package com.xstock.plutus.api.v1.company;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {
    Optional<Company> findByTicker(String ticker);
}
