package com.xstock.plutus.api.v1.ratio;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class RatioId implements Serializable {
    private Integer companyId;
    private Short quarter;
    private Short year;
}
