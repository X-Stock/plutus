package com.xstock.plutus.v1.cashflow;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class CashFlowId implements Serializable {
    private Integer companyId;
    private Short quarter;
    private Short year;
}
