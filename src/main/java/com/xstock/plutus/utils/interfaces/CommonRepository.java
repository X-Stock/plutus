package com.xstock.plutus.utils.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@NoRepositoryBean
public interface CommonRepository<T> extends PagingAndSortingRepository<T, Integer> {
    Optional<T> findByCompanyTicker(String ticker);

    Page<T> findAllByCompanyTicker(String ticker, Pageable pageable);
}
