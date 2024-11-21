package com.xstock.plutus.api.v1.stock.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.stock.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@NoArgsConstructor(force = true)
@Entity
@JsonIgnoreProperties(value = {"companyId", "company"})
public class Overview {
    @Id
    private final Integer companyId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Company company;

    @Column(columnDefinition = "TEXT")
    private final String exchange;

    @Column(columnDefinition = "TEXT")
    private final String industry;

    @Column(columnDefinition = "TEXT")
    private final String companyType;

    private final Integer numberOfShareholders;

    private final Float foreignPercent;

    private final Float outstandingShare;

    private final Float issueShare;

    private final Integer establishedYear;

    private final Integer numberOfEmployees;

    private final Float stockRating;

    private final Float deltaInWeek;

    private final Float deltaInMonth;

    private final Float deltaInYear;

    @Column(columnDefinition = "TEXT")
    private final String shortName;

    @Column(columnDefinition = "TEXT")
    private final String industryEn;

    private final Integer industryId;

    @Column(name = "industry_id_v2")
    private final Integer industryIdV2;

    @Column(columnDefinition = "TEXT")
    private final String website;
}
