package com.xstock.plutus.api.stock.v1.cashFlow;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class CashFlowId implements Serializable {
    private Integer companyId;
    private Short quarter;
    private Short year;
}
