package com.xstock.plutus.api.stock.v1.officer;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class OfficerId implements Serializable {
    private Integer companyId;
    private Short no;
}
