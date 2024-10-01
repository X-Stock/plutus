package com.xstock.plutus.api.v1.stockHistorical;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.OffsetDateTime;

@EqualsAndHashCode
public class StockHistoricalId implements Serializable {
    private int companyId;
    private OffsetDateTime time;
}
