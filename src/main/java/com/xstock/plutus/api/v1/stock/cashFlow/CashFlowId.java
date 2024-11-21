package com.xstock.plutus.api.v1.stock.cashFlow;

import java.io.Serializable;

record CashFlowId (
        Integer companyId,
        Short quarter,
        Short year
) implements Serializable {}
