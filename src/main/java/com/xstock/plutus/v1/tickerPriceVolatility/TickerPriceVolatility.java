package com.xstock.plutus.v1.tickerPriceVolatility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ticker_price_volatility")
public class TickerPriceVolatility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @Column(name = "ticker_highest_price", columnDefinition = "TEXT")
    private Float tickerHighestPrice;

    @Column(name = "ticker_lowest_price", columnDefinition = "TEXT")
    private Float tickerLowestPrice;

    @Column(name = "ticker_highest_price_percent", columnDefinition = "TEXT")
    private Float tickerHighestPricePercent;

    @Column(name = "ticker_lowest_price_percent", columnDefinition = "TEXT")
    private Float tickerLowestPricePercent;
}
