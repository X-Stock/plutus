package com.xstock.plutus.api.v1.stock.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {
    Optional<Company> findByTicker(String ticker);

    @Query(
            value = """
                    WITH calculated_metrics AS (
                        SELECT
                            c.ticker,
                            c.fullname_vi,
                            o.industry_en,
                            o.delta_in_year AS returns,
                            CAST((stddev(h.close) / avg(h.close)) AS REAL) AS volatility
                        FROM companies c
                        JOIN overview o ON c.id = o.company_id
                        JOIN stock_historical h ON c.id = h.company_id
                        GROUP BY c.ticker, c.fullname_vi, o.industry_en, o.delta_in_year
                    )
                    SELECT
                        ticker,
                        fullname_vi,
                        industry_en,
                        returns,
                        volatility,
                        CASE
                            WHEN volatility = 0 THEN
                                CASE
                                    WHEN returns < 0 THEN '-infinity'::numeric
                                    WHEN returns > 0 THEN '+infinity'::numeric
                                    ELSE 0
                                END
                            ELSE (returns / volatility)
                        END AS ratio
                    FROM calculated_metrics
                    ORDER BY ratio DESC
                    """,
            countQuery = "SELECT COUNT(*) FROM companies",
            nativeQuery = true
    )
    Page<Object[]> findAllWithMetrics(Pageable pageable);
}
