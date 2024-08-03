package com.xstock.plutus.v1.ratio;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class RatioId implements Serializable {
    private int company_id;
    private short quarter;
    private short year;
}
