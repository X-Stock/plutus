package com.xstock.plutus.api.v1.stock.cashFlow;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class CashFlowId implements Serializable {
    private Integer companyId;
    private Short quarter;
    private Short year;
}
