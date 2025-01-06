package com.xstock.plutus.api.v1.stock.incomeStatement;

import java.io.Serializable;

record IncomeStatementId(
        Integer companyId,
        Short quarter,
        Short year
) implements Serializable {
}
