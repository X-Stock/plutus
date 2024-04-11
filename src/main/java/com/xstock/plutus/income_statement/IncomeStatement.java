package com.xstock.plutus.income_statement;

import jakarta.persistence.*;
@Entity
@Table(name = "income_statement")
public class IncomeStatement {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="company_id")
    private Integer companyId;

    @Column(name="data")
    private String Data;

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

    public String getdata() {
        return Data;
    }

    public void setdata(String Data) {
        this.Data = Data;
    }
}
