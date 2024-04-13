package com.xstock.plutus.stockIntraday;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "stock_intraday")
public class StockIntraday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    private OffsetDateTime time;

    @Column(name = "order_type", columnDefinition="TEXT")
    private String orderType;

    private Integer volume;

    private Float price;

    @Column(name = "previous_price_change")
    private Float previousPriceChange;

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
