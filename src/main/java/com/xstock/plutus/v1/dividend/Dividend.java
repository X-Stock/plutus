package com.xstock.plutus.v1.dividend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "dividends", indexes = @Index(columnList = "company_id"))
public class Dividend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
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
