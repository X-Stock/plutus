package com.xstock.plutus.company_subsidiaries_listing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Company_subsidiaries_listing {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer company_id;

    private String sub_company_name;

    private Float sub_own_percent;

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getSub_company_name() {
        return sub_company_name;
    }

    public void setSub_company_name(String sub_company_name) {
        this.sub_company_name = sub_company_name;
    }

    public Float getSub_own_percent() {
        return sub_own_percent;
    }

    public void setSub_own_percent(Float sub_own_percent) {
        this.sub_own_percent = sub_own_percent;
    }
}
