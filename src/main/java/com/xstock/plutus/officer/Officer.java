package com.xstock.plutus.officer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;

@Entity
@Table(name="officers")
public class Officer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;

    @Column(columnDefinition="TEXT")
    private String name;

    @Column(columnDefinition="TEXT")
    private String position;

    @Column(name="own_percent")
    private Float ownPercent;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Float getOwnPercent() {
        return ownPercent;
    }

    public void setOwnPercent(Float ownPercent) {
        this.ownPercent = ownPercent;
    }
}
