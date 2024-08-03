package com.xstock.plutus.v1.incomeStatement;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class IncomeStatementId implements Serializable {
    private int company_id;
    private short quarter;
    private short year;
}
