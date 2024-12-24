package com.xstock.plutus.api.v1.stock.dividend;

import java.io.Serializable;
import java.time.Instant;

record DividendId(
        Integer companyId,
        Instant exerciseDate
) implements Serializable {
}
