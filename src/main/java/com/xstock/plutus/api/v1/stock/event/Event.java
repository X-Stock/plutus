package com.xstock.plutus.api.v1.stock.event;

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
@Table(name = "events", indexes = @Index(columnList = "companyId"))
@JsonIgnoreProperties(value = {"company"})
public class Event {
    @Id
    private final Long id;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Company company;

    private final Integer price;

    private final Integer priceChange;

    private final Float weeklyPriceChangeRatio;

    private final Float monthlyPriceChangeRatio;

    @Column(columnDefinition = "TEXT")
    private final String eventName;

    @Column(columnDefinition = "TEXT")
    private final String eventCode;

    private final Instant notifyDate;

    private final Instant exerciseDate;

    private final Instant registrationFinalDate;

    private final Instant exRightsDate;

    @Column(columnDefinition = "TEXT")
    private final String eventDescription;

    private final Float rsi;

    private final Float rs;
}
