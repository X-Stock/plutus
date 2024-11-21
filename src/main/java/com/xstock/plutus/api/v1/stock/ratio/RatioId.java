package com.xstock.plutus.api.v1.stock.ratio;

import java.io.Serializable;

record RatioId (
        Integer companyId,
        Short quarter,
        Short year
) implements Serializable {}
