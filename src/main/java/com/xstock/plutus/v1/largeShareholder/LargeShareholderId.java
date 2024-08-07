package com.xstock.plutus.v1.largeShareholder;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class LargeShareholderId implements Serializable {
    private int company_id;
    private short no;
}
