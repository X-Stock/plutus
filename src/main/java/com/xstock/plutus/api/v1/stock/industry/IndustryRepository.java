package com.xstock.plutus.api.v1.stock.industry;

import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.api.v1.stock.overview.Overview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndustryRepository extends PagingAndSortingRepository<Overview, Integer> {
    @Query("SELECT c FROM Overview o JOIN o.company c WHERE o.industry = :industry OR o.industryEn = :industry")
    Page<Company> findCompaniesByIndustry(@Param("industry") String industry, Pageable pageable);

    @Query("SELECT DISTINCT new com.xstock.plutus.api.v1.stock.industry.Industry(o.industry, o.industryEn) FROM Overview o")
    List<Industry> findAll();
}

