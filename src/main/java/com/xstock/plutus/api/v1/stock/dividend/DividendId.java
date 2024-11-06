package com.xstock.plutus.api.v1.stock.dividend;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.OffsetDateTime;

@EqualsAndHashCode
public class DividendId implements Serializable {
    private int companyId;
    private OffsetDateTime exerciseDate;
}
