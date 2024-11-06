package com.xstock.plutus.api.v1.stock.subsidiary;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class SubsidiaryId implements Serializable {
    private Integer companyId;
    private Short no;
}
