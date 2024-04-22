package com.xstock.plutus.v1.company;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    Optional<Company> findByTicker(String ticker);
}
