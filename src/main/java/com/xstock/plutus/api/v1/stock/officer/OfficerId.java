package com.xstock.plutus.api.v1.stock.officer;

import java.io.Serializable;

record OfficerId (
        Integer companyId,
        Short no
) implements Serializable {}
