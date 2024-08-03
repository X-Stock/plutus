package com.xstock.plutus.v1.insiderDeal;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.OffsetDateTime;

@EqualsAndHashCode
public class InsiderDealId implements Serializable {
    private int company_id;
    private OffsetDateTime dealAnnounceDate;
}
