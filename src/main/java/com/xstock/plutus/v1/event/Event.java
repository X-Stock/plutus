package com.xstock.plutus.v1.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Entity
@Table(name = "events", indexes = @Index(columnList = "companyId"))
@JsonIgnoreProperties(value = {"id", "company"})
public class Event {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    private Integer price;

    private Integer priceChange;

    private Float priceChangeRatio;

    private Float weeklyPriceChangeRatio;

    private Float monthlyPriceChangeRatio;

    @Column(columnDefinition = "TEXT")
    private String eventName;

    @Column(columnDefinition = "TEXT")
    private String eventCode;

    private OffsetDateTime notifyDate;

    private OffsetDateTime exerciseDate;

    private OffsetDateTime registrationFinalDate;

    private OffsetDateTime exRightsDate;

    @Column(columnDefinition = "TEXT")
    private String eventDescription;

    private Float rsi;

    private Float rs;
}
