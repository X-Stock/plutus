package com.xstock.plutus.api.v1.stock.stockHistorical;

import com.xstock.plutus.utils.interfaces.CommonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;

public interface StockHistoricalRepository extends CommonRepository<StockHistorical> {
    @Query("SELECT h FROM StockHistorical h " +
            "JOIN h.company c " +
            "WHERE c.ticker = :ticker " +
            "AND h.time BETWEEN :startDate AND :endDate")
    Page<StockHistorical> findAllByCompanyTickerInRange(
            @Param("ticker") String ticker,
            @Param("startDate") OffsetDateTime startDate,
            @Param("endDate") OffsetDateTime endDate,
            Pageable pageable
    );
}
