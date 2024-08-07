package com.xstock.plutus.v1.subsidiary;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class SubsidiaryId implements Serializable {
    private int company_id;
    private short no;
}
