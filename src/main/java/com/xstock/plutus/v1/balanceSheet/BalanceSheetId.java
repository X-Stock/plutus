package com.xstock.plutus.v1.balanceSheet;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class BalanceSheetId implements Serializable {
    private int company_id;
    private short quarter;
    private short year;
}
