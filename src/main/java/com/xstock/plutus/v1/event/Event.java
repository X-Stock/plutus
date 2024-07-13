package com.xstock.plutus.v1.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    private Integer price;

    @Column(name = "price_change")
    private Integer priceChange;

    @Column(name = "price_change_ratio")
    private Float priceChangeRatio;

    @Column(name = "weekly_price_change_ratio")
    private Float weeklyPriceChangeRatio;

    @Column(name = "monthly_price_change_ratio")
    private Float monthlyPriceChangeRatio;

    @Column(name = "event_name", columnDefinition = "TEXT")
    private String eventName;

    @Column(name = "event_code", columnDefinition = "TEXT")
    private String eventCode;

    @Column(name = "notify_date")
    private OffsetDateTime notifyDate;

    @Column(name = "exercise_date")
    private OffsetDateTime exerciseDate;

    @Column(name = "registration_final_date")
    private OffsetDateTime registrationFinalDate;

    @Column(name = "ex_rights_date")
    private OffsetDateTime exRightsDate;

    @Column(name = "event_description", columnDefinition = "TEXT")
    private String eventDescription;

    private Float rsi;

    private Float rs;
}
