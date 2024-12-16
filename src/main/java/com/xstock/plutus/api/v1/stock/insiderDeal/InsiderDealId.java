package com.xstock.plutus.api.v1.stock.insiderDeal;

import java.io.Serializable;
import java.time.OffsetDateTime;

record InsiderDealId(
        Integer companyId,
        OffsetDateTime dealAnnounceDate
) implements Serializable {
}
