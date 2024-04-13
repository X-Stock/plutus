package com.xstock.plutus.incomeStatement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;

@Entity
@Table(name = "income_statement")
public class IncomeStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String Data) {
        this.data = Data;
    }
}
