package com.xstock.plutus.api.v1.stock.insiderDeal;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.OffsetDateTime;

@EqualsAndHashCode
public class InsiderDealId implements Serializable {
    private int companyId;
    private OffsetDateTime dealAnnounceDate;
}
