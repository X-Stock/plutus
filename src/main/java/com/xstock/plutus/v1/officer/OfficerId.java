package com.xstock.plutus.v1.officer;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class OfficerId implements Serializable {
    private int company_id;
    private short no;
}
