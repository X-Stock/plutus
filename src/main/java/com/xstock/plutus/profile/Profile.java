package com.xstock.plutus.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;

    @Column(name="companyName", columnDefinition="TEXT")
    private String companyName;

    @Column(columnDefinition="TEXT")
    private String profile;

    @Column(columnDefinition="TEXT")
    private String historyDev;

    @Column(columnDefinition="TEXT")
    private String promise;

    @Column(name="business_risk", columnDefinition="TEXT")
    private String businessRisk;

    @Column(name="key_developments", columnDefinition="TEXT")
    private String keyDevelopments;

    @Column(name="business_strategies", columnDefinition="TEXT")
    private String businessStrategies;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getHistoryDev() {
        return historyDev;
    }

    public void setHistoryDev(String historyDev) {
        this.historyDev = historyDev;
    }

    public String getPromise() {
        return promise;
    }

    public void setPromise(String promise) {
        this.promise = promise;
    }

    public String getBusinessRisk() {
        return businessRisk;
    }

    public void setBusinessRisk(String businessRisk) {
        this.businessRisk = businessRisk;
    }

    public String getKeyDevelopments() {
        return keyDevelopments;
    }

    public void setKeyDevelopments(String keyDevelopments) {
        this.keyDevelopments = keyDevelopments;
    }

    public String getBusinessStrategies() {
        return businessStrategies;
    }

    public void setBusinessStrategies(String businessStrategies) {
        this.businessStrategies = businessStrategies;
    }
}
