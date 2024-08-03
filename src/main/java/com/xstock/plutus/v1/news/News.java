package com.xstock.plutus.v1.news;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(indexes = @Index(columnList = "company_id"))
@JsonIgnoreProperties(value = {"id", "company"})
public class News {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    private Integer price;

    @Column(name = "price_change")
    private Integer priceChange;

    @Column(name = "price_change_ratio")
    private Float priceChangeRatio;

    @Column(name = "monthly_price_change_ratio")
    private Float MonthlyPriceChangeRatio;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String source;

    @Column(name = "publish_date")
    private OffsetDateTime publishDate;

    private Float rsi;

    private Float rs;
}
