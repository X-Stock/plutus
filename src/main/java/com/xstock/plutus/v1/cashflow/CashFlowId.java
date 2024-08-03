package com.xstock.plutus.v1.cashflow;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class CashFlowId implements Serializable {
    private int company_id;
    private short quarter;
    private short year;
}
