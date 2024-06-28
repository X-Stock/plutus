package com.xstock.plutus.v1.news;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
public class News {
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

//    @Column(name = "weekly_price_change_ratio")
//    private Float weeklyPriceChangeRatio;

    @Column(name = "monthly_price_change_ratio")
    private Float MonthlyPriceChangeRatio;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String source;

    @Column(name = "publish_date")
    private OffsetDateTime publishDate;

    private Double rsi;

    private Double rs;
}
