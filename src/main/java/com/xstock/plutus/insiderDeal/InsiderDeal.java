package com.xstock.plutus.insiderDeal;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "insider_deals")
public class InsiderDeal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="company_id")
    private Integer companyId;

    @Column(name="deal_announce_date")
    private OffsetDateTime dealAnnounceDate;

    @Column(name="deal_method")
    private String dealMethod;

    @Column(name="deal_action")
    private String dealAction;

    @Column(name="deal_quantity")
    private Integer dealQuantity;

    @Column(name="deal_price")
    private Integer dealPrice;

    @Column(name="deal_ratio")
    private Float dealRatio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public OffsetDateTime getDealAnnounceDate() {
        return dealAnnounceDate;
    }

    public void setDealAnnounceDate(OffsetDateTime dealAnnounceDate) {
        this.dealAnnounceDate = dealAnnounceDate;
    }

    public String getDealMethod() {
        return dealMethod;
    }

    public void setDealMethod(String dealMethod) {
        this.dealMethod = dealMethod;
    }

    public String getDealAction() {
        return dealAction;
    }

    public void setDealAction(String dealAction) {
        this.dealAction = dealAction;
    }

    public Integer getDealQuantity() {
        return dealQuantity;
    }

    public void setDealQuantity(Integer dealQuantity) {
        this.dealQuantity = dealQuantity;
    }

    public Integer getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(Integer dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Float getDealRatio() {
        return dealRatio;
    }

    public void setDealRatio(Float dealRatio) {
        this.dealRatio = dealRatio;
    }
}
