package com.xstock.plutus.api.v1.stock.dividend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.stock.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Entity
@Table(name = "dividends")
@IdClass(DividendId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class Dividend {
    @Id
    private Integer companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private OffsetDateTime exerciseDate;

    private Short cashYear;

    private Float cashDividendPercentage;

    @Column(columnDefinition = "TEXT")
    private String issueMethod;
}
