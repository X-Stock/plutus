package com.xstock.plutus.api.v1.stock.stockHistorical;

import java.io.Serializable;
import java.time.OffsetDateTime;

record StockHistoricalId(
        Integer companyId,
        OffsetDateTime time
) implements Serializable {
}
