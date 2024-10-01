package com.xstock.plutus.api.v1.balanceSheet;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class BalanceSheetId implements Serializable {
    private Integer companyId;
    private Short quarter;
    private Short year;
}
