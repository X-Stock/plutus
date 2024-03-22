package com.xstock.plutus.stock_indices_company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock_indices_company {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer company_id;

    private Integer stock_indices_id;

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getStock_indices_id() {
        return stock_indices_id;
    }

    public void setStock_indices_id(Integer stock_indices_id) {
        this.stock_indices_id = stock_indices_id;
    }
}
