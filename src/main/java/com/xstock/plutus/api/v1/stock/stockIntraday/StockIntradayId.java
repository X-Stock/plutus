package com.xstock.plutus.api.v1.stock.stockIntraday;

import java.io.Serializable;
import java.time.OffsetDateTime;

record StockIntradayId(
        Integer companyId,
        OffsetDateTime time
) implements Serializable {
}
