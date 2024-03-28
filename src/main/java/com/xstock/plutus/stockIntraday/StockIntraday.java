package com.xstock.plutus.stockIntraday;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name="stock_intraday")
public class StockIntraday {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="company_id")
    private Integer companyId;

    private OffsetDateTime time;

    @Column(name="order_type")
    private String orderType;

    private Integer volume;

    private Float price;

    @Column(name="previous_price_change")
    private Float previousPriceChange;

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

    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPreviousPriceChange() {
        return previousPriceChange;
    }

    public void setPreviousPriceChange(Float previousPriceChange) {
        this.previousPriceChange = previousPriceChange;
    }
}
