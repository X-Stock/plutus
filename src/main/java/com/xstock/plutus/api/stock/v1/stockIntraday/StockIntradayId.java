package com.xstock.plutus.api.stock.v1.stockIntraday;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.OffsetDateTime;

@EqualsAndHashCode
public class StockIntradayId implements Serializable {
    private int companyId;
    private OffsetDateTime time;
}
