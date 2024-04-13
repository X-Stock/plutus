package com.xstock.plutus.largeShareholder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;

@Entity
@Table(name = "large_shareholders")
public class LargeShareholder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @Column(columnDefinition="TEXT")
    private String shareholder;

    @Column(name = "share_own_percent")
    private Float shareOwnPercent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
