package com.xstock.plutus.api.v1.stock.industry;

import com.xstock.plutus.api.v1.stock.overview.Overview;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IndustryInterface extends CrudRepository<Overview, Integer> {
    @Query(value = "SELECT o.industry, json_agg(c) " +
            "FROM overview o " +
            "JOIN companies c ON o.company_id = c.id " +
            "GROUP BY o.industry", nativeQuery = true)
    Iterable<Object[]> findIndustryWithCompanies();
}

