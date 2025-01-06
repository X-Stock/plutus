package com.xstock.plutus.api.v1.stock.largeShareholder;

import java.io.Serializable;

record LargeShareholderId(
        Integer companyId,
        Short no
) implements Serializable {
}
