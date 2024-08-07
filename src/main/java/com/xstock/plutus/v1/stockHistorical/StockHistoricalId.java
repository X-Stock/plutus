package com.xstock.plutus.v1.stockHistorical;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.OffsetDateTime;

@EqualsAndHashCode
public class StockHistoricalId implements Serializable {
    private int company_id;
    private OffsetDateTime time;
}
