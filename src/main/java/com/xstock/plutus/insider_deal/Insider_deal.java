package com.xstock.plutus.insider_deal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Insider_deal {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Date deal_announce_date;

    private String deal_method;

    private String deal_action;

    private Integer deal_quantity;

    private Integer deal_price;

    private Integer deal_ratio;

    public Date getDeal_announce_date() {
        return deal_announce_date;
    }

    public void setDeal_announce_date(Date deal_announce_date) {
        this.deal_announce_date = deal_announce_date;
    }

    public String getDeal_method() {
        return deal_method;
    }

    public void setDeal_method(String deal_method) {
        this.deal_method = deal_method;
    }

    public String getDeal_action() {
        return deal_action;
    }

    public void setDeal_action(String deal_action) {
        this.deal_action = deal_action;
    }

    public Integer getDeal_quantity() {
        return deal_quantity;
    }

    public void setDeal_quantity(Integer deal_quantity) {
        this.deal_quantity = deal_quantity;
    }

    public Integer getDeal_price() {
        return deal_price;
    }

    public void setDeal_price(Integer deal_price) {
        this.deal_price = deal_price;
    }

    public Integer getDeal_ratio() {
        return deal_ratio;
    }

    public void setDeal_ratio(Integer deal_ratio) {
        this.deal_ratio = deal_ratio;
    }
}
