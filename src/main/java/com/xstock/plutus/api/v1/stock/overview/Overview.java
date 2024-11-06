package com.xstock.plutus.api.v1.stock.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.stock.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@JsonIgnoreProperties(value = {"companyId", "company"})
public class Overview {
    @Id
    private int companyId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Column(columnDefinition = "TEXT")
    private String exchange;

    @Column(columnDefinition = "TEXT")
    private String industry;

    @Column(columnDefinition = "TEXT")
    private String companyType;

    private Integer numberOfShareholders;

    private Float foreignPercent;

    private Float outstandingShare;

    private Float issueShare;

    private Integer establishedYear;

    private Integer numberOfEmployees;

    private Float stockRating;

    private Float deltaInWeek;

    private Float deltaInMonth;

    private Float deltaInYear;

    @Column(columnDefinition = "TEXT")
    private String shortName;

    @Column(columnDefinition = "TEXT")
    private String industryEn;

    private Integer industryId;

    @Column(name = "industry_id_v2")
    private Integer industryIdV2;

    @Column(columnDefinition = "TEXT")
    private String website;
}
