package com.xstock.plutus.api.v1.stock.insiderDeal;

import java.io.Serializable;
import java.time.Instant;

record InsiderDealId(
        Integer companyId,
        Instant dealAnnounceDate
) implements Serializable {
}
