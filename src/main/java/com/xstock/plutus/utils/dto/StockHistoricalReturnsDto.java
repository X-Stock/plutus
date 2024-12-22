package com.xstock.plutus.utils.dto;

import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
@Getter
public class StockHistoricalReturnsDto implements StockHistoricalReturns {
    private final Instant time;
    private final Float returns;
}