package com.xstock.plutus.api.v1.largeShareholder;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class LargeShareholderId implements Serializable {
    private Integer companyId;
    private Short no;
}
