package com.xstock.plutus.api.v1.stock.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {
    Optional<Company> findByTicker(String ticker);

    @NativeQuery(
            value = """
                   WITH ranked_data AS (
                       SELECT
                           company_id,
                           close,
                           time,
                           ROW_NUMBER() OVER (PARTITION BY company_id ORDER BY time DESC) AS rank
                       FROM stock_historical
                   ),
                   prices AS (
                       SELECT
                           company_id,
                           MAX(CASE WHEN rank = 1 THEN close END) AS current_price,
                           MAX(CASE WHEN rank = 2 THEN close END) AS last_price
                       FROM ranked_data
                       GROUP BY company_id
                   ),
                   calculated_metrics AS (
                       SELECT
                           c.ticker,
                           c.fullname_vi,
                           o.industry_en,
                           p.current_price,
                           (p.current_price - p.last_price) / p.last_price::real AS price_diff,
                           o.delta_in_year AS returns,
                           (stddev(h.close) / avg(h.close))::real AS volatility
                       FROM companies c
                       JOIN overview o ON c.id = o.company_id
                       JOIN prices p ON c.id = p.company_id
                       JOIN stock_historical h ON c.id = h.company_id
                       GROUP BY c.ticker, c.fullname_vi, o.industry_en, o.delta_in_year, p.current_price, p.last_price
                   )
                   SELECT
                       ticker,
                       fullname_vi,
                       industry_en,
                       current_price,
                       price_diff,
                       returns,
                       volatility,
                       CASE
                           WHEN volatility = 0 THEN
                               CASE
                                   WHEN returns < 0 THEN '-infinity'::real
                                   WHEN returns > 0 THEN '+infinity'::real
                                   ELSE 0
                               END
                           ELSE (returns / volatility)
                       END AS ratio
                   FROM calculated_metrics
                   """,
            countQuery = "SELECT COUNT(*) FROM companies"
    )
    Page<CompanyMetrics> findAllWithMetrics(Pageable pageable);
}
