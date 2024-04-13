package com.xstock.plutus.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "event_name", columnDefinition="TEXT")
    private String eventName;

    @Column(name = "event_code", columnDefinition="TEXT")
    private String eventCode;

    @Column(name = "notify_date")
    private OffsetDateTime notifyDate;

    @Column(name = "exercise_date")
    private OffsetDateTime exerciseDate;

    @Column(name = "registration_final_date")
    private OffsetDateTime registrationFinalDate;

    @Column(name = "ex_rights_date")
    private OffsetDateTime exRightsDate;

    @Column(name = "event_description", columnDefinition="TEXT")
    private String eventDescription;

    @Column(name = "event_note", columnDefinition="TEXT")
    private String eventNote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Integer priceChange) {
        this.priceChange = priceChange;
    }

    public Float getPriceChangeRatio() {
        return priceChangeRatio;
    }

    public void setPriceChangeRatio(Float priceChangeRatio) {
        this.priceChangeRatio = priceChangeRatio;
    }

    public Float getWeeklyPriceChangeRatio() {
        return weeklyPriceChangeRatio;
    }

    public void setWeeklyPriceChangeRatio(Float weeklyPriceChangeRatio) {
        this.weeklyPriceChangeRatio = weeklyPriceChangeRatio;
    }

    public Float getMonthlyPriceChangeRatio() {
        return monthlyPriceChangeRatio;
    }

    public void setMonthlyPriceChangeRatio(Float monthlyPriceChangeRatio) {
        this.monthlyPriceChangeRatio = monthlyPriceChangeRatio;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public OffsetDateTime getNotifyDate() {
        return notifyDate;
    }

    public void setNotifyDate(OffsetDateTime notifyDate) {
        this.notifyDate = notifyDate;
    }

    public OffsetDateTime getExerciseDate() {
        return exerciseDate;
    }

    public void setExerciseDate(OffsetDateTime exerciseDate) {
        this.exerciseDate = exerciseDate;
    }

    public OffsetDateTime getRegistrationFinalDate() {
        return registrationFinalDate;
    }

    public void setRegistrationFinalDate(OffsetDateTime registrationFinalDate) {
        this.registrationFinalDate = registrationFinalDate;
    }

    public OffsetDateTime getExRightsDate() {
        return exRightsDate;
    }

    public void setExRightsDate(OffsetDateTime exRightsDate) {
        this.exRightsDate = exRightsDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventNote() {
        return eventNote;
    }

    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
    }
}
