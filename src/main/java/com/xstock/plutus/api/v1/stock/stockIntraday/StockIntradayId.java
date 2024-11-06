package com.xstock.plutus.api.v1.stock.stockIntraday;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.OffsetDateTime;

@EqualsAndHashCode
public class StockIntradayId implements Serializable {
    private int companyId;
    private OffsetDateTime time;
}
