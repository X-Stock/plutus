package com.xstock.plutus.utils;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CommonRepository<T> extends CrudRepository<T, Integer> {
    Optional<T> findByCompany_Ticker(String ticker);

    Iterable<T> findAllByCompany_Ticker(String ticker);
}
