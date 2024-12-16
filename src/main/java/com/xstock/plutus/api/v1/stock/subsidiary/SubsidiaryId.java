package com.xstock.plutus.api.v1.stock.subsidiary;

import java.io.Serializable;

record SubsidiaryId(
        Integer companyId,
        Short no
) implements Serializable {
}
