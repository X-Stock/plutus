package com.xstock.plutus.api.v1.stock.exchange;

import com.xstock.plutus.api.v1.stock.company.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExchangeRepository extends PagingAndSortingRepository<Company, Integer> {
  Page<Company> findAllByExchange(String exchange, Pageable pageable);

  @Query("SELECT DISTINCT c.exchange FROM Company c")
  Iterable<String> findAll();
}