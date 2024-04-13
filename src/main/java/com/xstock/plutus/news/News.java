package com.xstock.plutus.news;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;

    private Integer price;

    @Column(name="price_change")
    private Integer priceChange;

    @Column(name="price_change_ratio")
    private Float priceChangeRatio;

    @Column(name="weekly_price_change_ratio")
    private Float weeklyPriceChangeRatio;

    @Column(name="monthly_price_change_ratio")
    private Float MonthlyPriceChangeRatio;

    @Column(columnDefinition="TEXT")
    private String title;

    @Column(columnDefinition="TEXT")
    private String source;

    @Column(name="publish_date")
    private OffsetDateTime publishDate;

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
        return MonthlyPriceChangeRatio;
    }

    public void setMonthlyPriceChangeRatio(Float monthlyPriceChangeRatio) {
        MonthlyPriceChangeRatio = monthlyPriceChangeRatio;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public OffsetDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(OffsetDateTime publishDate) {
        this.publishDate = publishDate;
    }
}
