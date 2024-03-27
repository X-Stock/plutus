package com.xstock.plutus.largeShareholder;

import jakarta.persistence.*;

@Entity
@Table(name="large_shareholders")
public class LargeShareholder {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="company_id")
    private Integer companyId;

    private String shareholder;

    @Column(name="share_own_percent")
    private Float shareOwnPercent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getShareholder() {
        return shareholder;
    }

    public void setShareholder(String shareholder) {
        this.shareholder = shareholder;
    }

    public Float getShareOwnPercent() {
        return shareOwnPercent;
    }

    public void setShareOwnPercent(Float shareOwnPercent) {
        this.shareOwnPercent = shareOwnPercent;
    }
}
