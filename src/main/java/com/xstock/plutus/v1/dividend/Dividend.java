package com.xstock.plutus.v1.dividend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Entity
@Table(name = "dividends" )
@IdClass(DividendId.class)
@JsonIgnoreProperties(value = {"company_id", "company"})
public class Dividend {
    @Id
    private int company_id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "company_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    @Column(name = "exercise_date")
    private OffsetDateTime exerciseDate;

    @Column(name = "cash_year")
    private Short cashYear;

    @Column(name = "cash_dividend_percentage")
    private Float cashDividendPercentage;

    @Column(name = "issue_method", columnDefinition = "TEXT")
    private String issueMethod;
}
