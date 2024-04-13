package com.xstock.plutus.tickerPriceVolatility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;

@Entity
@Table(name="ticker_price_volatility")
public class TickerPriceVolatility {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;

    @Column(name="ticker_highest_price", columnDefinition="TEXT")
    private Float tickerHighestPrice;

    @Column(name="ticker_lowest_price", columnDefinition="TEXT")
    private Float tickerLowestPrice;

    @Column(name="ticker_highest_price_percent", columnDefinition="TEXT")
    private Float tickerHighestPricePercent;

    @Column(name="ticker_lowest_price_percent", columnDefinition="TEXT")
    private Float tickerLowestPricePercent;

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

    public Float getTickerHighestPrice() {
        return tickerHighestPrice;
    }

    public void setTickerHighestPrice(Float tickerHighestPrice) {
        this.tickerHighestPrice = tickerHighestPrice;
    }

    public Float getTickerLowestPrice() {
        return tickerLowestPrice;
    }

    public void setTickerLowestPrice(Float tickerLowestPrice) {
        this.tickerLowestPrice = tickerLowestPrice;
    }

    public Float getTickerHighestPricePercent() {
        return tickerHighestPricePercent;
    }

    public void setTickerHighestPricePercent(Float tickerHighestPricePercent) {
        this.tickerHighestPricePercent = tickerHighestPricePercent;
    }

    public Float getTickerLowestPricePercent() {
        return tickerLowestPricePercent;
    }

    public void setTickerLowestPricePercent(Float tickerLowestPricePercent) {
        this.tickerLowestPricePercent = tickerLowestPricePercent;
    }
}
