package com.xstock.plutus.api.v1.stock.balanceSheet;

import java.io.Serializable;

record BalanceSheetId(
        Integer companyId,
        Short quarter,
        Short year
) implements Serializable {
}
