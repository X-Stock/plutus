package com.xstock.plutus.api.v1.stock.stockIntraday;

import java.io.Serializable;
import java.time.Instant;

record StockIntradayId(
        Integer companyId,
        Instant time
) implements Serializable {
}
