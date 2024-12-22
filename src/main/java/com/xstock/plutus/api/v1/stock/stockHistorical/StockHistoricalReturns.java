package com.xstock.plutus.api.v1.stock.stockHistorical;

import java.time.Instant;

public interface StockHistoricalReturns {
    Instant getTime();
    Float getReturns();
}
