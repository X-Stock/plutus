package com.xstock.plutus.api.stock.v1.subsidiary;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class SubsidiaryId implements Serializable {
    private Integer companyId;
    private Short no;
}
