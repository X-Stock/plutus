package com.xstock.plutus.api.v1.stock.dividend;

import java.io.Serializable;
import java.time.OffsetDateTime;

record DividendId (
        Integer companyId,
        OffsetDateTime exerciseDate
) implements Serializable {}
