package com.xstock.plutus.api.v1.stock.dividend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.stock.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@NoArgsConstructor(force = true)
@Entity
@Table(name = "dividends")
@IdClass(DividendId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class Dividend {
    @Id
    private final Integer companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Company company;

    @Id
    private final Instant exerciseDate;

    private final Short cashYear;

    private final Float cashDividendPercentage;

    @Column(columnDefinition = "TEXT")
    private final String issueMethod;
}
