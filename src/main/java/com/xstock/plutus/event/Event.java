package com.xstock.plutus.event;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="company_id")
    private Integer companyId;

    private Integer price;

    @Column(name="price_change")
    private Integer priceChange;

    @Column(name="price_change_ratio")
    private Float priceChangeRatio;

    @Column(name="weekly_price_change_ratio")
    private Float weeklyPriceChangeRatio;

    @Column(name="monthly_price_change_ratio")
    private Float monthlyPriceChangeRatio;

    @Column(name="event_name")
    private String eventName;

    @Column(name="event_code")
    private String eventCode;

    @Column(name="notify_date")
    private OffsetDateTime notifyDate;

    @Column(name="exercise_date")
    private OffsetDateTime exerciseDate;

    @Column(name="registration_final_date")
    private OffsetDateTime registrationFinalDate;

    @Column(name="ex_rights_date")
    private OffsetDateTime exRightsDate;

    @Column(name="event_description")
    private String eventDescription;

    @Column(name="event_note")
    private String eventNote;
}
