package com.xstock.plutus.v1.dividend;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.OffsetDateTime;

@EqualsAndHashCode
public class DividendId implements Serializable {
    private int companyId;
    private OffsetDateTime exerciseDate;
}
