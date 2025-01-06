package com.xstock.plutus.api.v1.stock.stockHistorical;

import java.io.Serializable;
import java.time.Instant;

record StockHistoricalId(
        Integer companyId,
        Instant time
) implements Serializable {
}
