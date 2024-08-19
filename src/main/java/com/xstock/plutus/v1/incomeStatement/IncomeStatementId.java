package com.xstock.plutus.v1.incomeStatement;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class IncomeStatementId implements Serializable {
    private Integer companyId;
    private Short quarter;
    private Short year;
}
