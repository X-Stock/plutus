package com.xstock.plutus.subsidiary;

import jakarta.persistence.*;

@Entity
@Table(name="subsidiaries")
public class Subsidiary {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="company_id")
    private Integer companyId;

    private String name;

    @Column(name="own_percent")
    private Float ownPercent;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getOwnPercent() {
        return ownPercent;
    }

    public void setOwnPercent(Float ownPercent) {
        this.ownPercent = ownPercent;
    }
}
