package com.xstock.plutus.overview;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;

@Entity
public class Overview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @Column(columnDefinition="TEXT")
    private String exchange;

    @Column(columnDefinition="TEXT")
    private String industry;

    @Column(name = "company_type", columnDefinition="TEXT")
    private String companyType;

    @Column(name = "number_of_shareholders")
    private Integer numberOfShareholders;

    @Column(name = "foreign_percent")
    private Float foreignPercent;

    @Column(name = "outstanding_share")
    private Float outstandingShare;

    @Column(name = "issue_share")
    private Float issueShare;

    @Column(name = "established_year")
    private Integer establishedYear;

    @Column(name = "number_of_employees")
    private Integer numberOfEmployees;

    @Column(name = "stock_rating")
    private Float stockRating;

    @Column(name = "delta_in_week")
    private Float deltaInWeek;

    @Column(name = "delta_in_month")
    private Float deltaInMonth;

    @Column(name = "delta_in_year")
    private Float deltaInYear;

    @Column(name = "short_name", columnDefinition="TEXT")
    private String shortName;

    @Column(name = "industry_en", columnDefinition="TEXT")
    private String industryEn;

    @Column(name = "industry_id")
    private Integer industryId;

    @Column(name = "industry_id_v2")
    private Integer industryIdV2;

    @Column(columnDefinition="TEXT")
    private String website;

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

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public Integer getNumberOfShareholders() {
        return numberOfShareholders;
    }

    public void setNumberOfShareholders(Integer numberOfShareholders) {
        this.numberOfShareholders = numberOfShareholders;
    }

    public Float getForeignPercent() {
        return foreignPercent;
    }

    public void setForeignPercent(Float foreignPercent) {
        this.foreignPercent = foreignPercent;
    }

    public Float getOutstandingShare() {
        return outstandingShare;
    }

    public void setOutstandingShare(Float outstandingShare) {
        this.outstandingShare = outstandingShare;
    }

    public Float getIssueShare() {
        return issueShare;
    }

    public void setIssueShare(Float issueShare) {
        this.issueShare = issueShare;
    }

    public Integer getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(Integer establishedYear) {
        this.establishedYear = establishedYear;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Float getStockRating() {
        return stockRating;
    }

    public void setStockRating(Float stockRating) {
        this.stockRating = stockRating;
    }

    public Float getDeltaInWeek() {
        return deltaInWeek;
    }

    public void setDeltaInWeek(Float deltaInWeek) {
        this.deltaInWeek = deltaInWeek;
    }

    public Float getDeltaInMonth() {
        return deltaInMonth;
    }

    public void setDeltaInMonth(Float deltaInMonth) {
        this.deltaInMonth = deltaInMonth;
    }

    public Float getDeltaInYear() {
        return deltaInYear;
    }

    public void setDeltaInYear(Float deltaInYear) {
        this.deltaInYear = deltaInYear;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getIndustryEn() {
        return industryEn;
    }

    public void setIndustryEn(String industryEn) {
        this.industryEn = industryEn;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public Integer getIndustryIdV2() {
        return industryIdV2;
    }

    public void setIndustryIdV2(Integer industryIdV2) {
        this.industryIdV2 = industryIdV2;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
