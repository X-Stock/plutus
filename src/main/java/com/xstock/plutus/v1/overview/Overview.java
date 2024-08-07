package com.xstock.plutus.v1.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@JsonIgnoreProperties(value = {"company_id", "company"})
public class Overview {
    @Id
    private int company_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "company_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Column(columnDefinition = "TEXT")
    private String exchange;

    @Column(columnDefinition = "TEXT")
    private String industry;

    @Column(name = "company_type", columnDefinition = "TEXT")
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

    @Column(name = "short_name", columnDefinition = "TEXT")
    private String shortName;

    @Column(name = "industry_en", columnDefinition = "TEXT")
    private String industryEn;

    @Column(name = "industry_id")
    private Integer industryId;

    @Column(name = "industry_id_v2")
    private Integer industryIdV2;

    @Column(columnDefinition = "TEXT")
    private String website;
}
