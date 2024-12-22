package com.xstock.plutus.api.v1.stock.stockHistorical;

import com.xstock.plutus.utils.interfaces.CommonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;

public interface StockHistoricalRepository extends CommonRepository<StockHistorical> {
    String findAllQuery = """
            SELECT h FROM StockHistorical h
            JOIN h.company c
            WHERE c.ticker = :ticker
            """;

    String findReturnsQuery = """
            WITH bucket_data AS (
              SELECT
                time_bucket((:interval)::interval, h.time) AS bucket,
                first(h.close, h.time) AS price
              FROM stock_historical h
              JOIN companies c ON c.id = h.company_id AND c.ticker = :ticker
              GROUP BY bucket
            ),
            bucket_data_with_lag AS (
              SELECT
                bucket,
                price,
                LAG(price, 1, 0) OVER (ORDER BY bucket) AS prev_close
              FROM bucket_data
            )
            SELECT
              bucket as time,
              CASE
                WHEN prev_close = 0 THEN 0
                ELSE (price - prev_close)::real / prev_close
              END AS returns
            FROM bucket_data_with_lag
            """;

    String findReturnsCountQuery = """
            SELECT COUNT(DISTINCT time_bucket((:interval)::interval, h.time))
            FROM stock_historical h
            JOIN companies c ON c.id = h.company_id AND c.ticker = :ticker
            """;

    @Query(findAllQuery + " AND h.time BETWEEN :startDate AND :endDate")
    Page<StockHistorical> findAllByCompanyTickerInRange(
            @Param("ticker") String ticker,
            @Param("startDate") OffsetDateTime startDate,
            @Param("endDate") OffsetDateTime endDate,
            Pageable pageable
    );

    @Query(findAllQuery + " AND h.time >= :startDate")
    Page<StockHistorical> findAllByCompanyTickerFromDate(
            @Param("ticker") String ticker,
            @Param("startDate") OffsetDateTime startDate,
            Pageable pageable
    );

    @Query(findAllQuery + " AND h.time <= :endDate")
    Page<StockHistorical> findAllByCompanyTickerToDate(
            @Param("ticker") String ticker,
            @Param("endDate") OffsetDateTime endDate,
            Pageable pageable
    );

    @NativeQuery(value= findReturnsQuery, countQuery = findReturnsCountQuery)
    Page<StockHistoricalReturns> findReturnsByCompanyTicker(
            @Param("ticker") String ticker,
            @Param("interval") String interval,
            Pageable pageable
    );

    @NativeQuery(
            value= findReturnsQuery + " WHERE bucket BETWEEN :startDate AND :endDate",
            countQuery = findReturnsCountQuery + " WHERE h.time BETWEEN :startDate AND :endDate"
    )
    Page<StockHistoricalReturns> findReturnsByCompanyTickerInRange(
            @Param("ticker") String ticker,
            @Param("interval") String interval,
            @Param("startDate") OffsetDateTime startDate,
            @Param("endDate") OffsetDateTime endDate,
            Pageable pageable
    );

    @NativeQuery(
            value= findReturnsQuery + " WHERE bucket >= :startDate",
            countQuery = findReturnsCountQuery + " WHERE h.time >= :startDate"
    )
    Page<StockHistoricalReturns> findReturnsByCompanyTickerFromDate(
            @Param("ticker") String ticker,
            @Param("interval") String interval,
            @Param("startDate") OffsetDateTime startDate,
            Pageable pageable
    );

    @NativeQuery(
            value= findReturnsQuery + " WHERE bucket <= :endDate",
            countQuery = findReturnsCountQuery + " WHERE h.time <= :endDate"
    )
    Page<StockHistoricalReturns> findReturnsByCompanyTickerToDate(
            @Param("ticker") String ticker,
            @Param("interval") String interval,
            @Param("endDate") OffsetDateTime endDate,
            Pageable pageable
    );
}
