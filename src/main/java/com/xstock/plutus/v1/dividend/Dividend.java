package com.xstock.plutus.v1.dividend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "dividends")
public class Dividend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @Column(name = "exercise_date")
    private OffsetDateTime exerciseDate;

    @Column(name = "cash_year")
    private Short cashYear;

    @Column(name = "cash_dividend_percentage")
    private Float cashDividendPercentage;

    @Column(name = "issue_method", columnDefinition = "TEXT")
    private String issueMethod;
}
