package com.xstock.plutus.api.stock.v1.insiderDeal;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.OffsetDateTime;

@EqualsAndHashCode
public class InsiderDealId implements Serializable {
    private int companyId;
    private OffsetDateTime dealAnnounceDate;
}
