package com.xstock.plutus.api.v1.news;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Entity
@Table(indexes = @Index(columnList = "companyId"))
@JsonIgnoreProperties(value = {"id", "company"})
public class News {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    private Integer price;

    private Integer priceChange;

    private Float weeklyPriceChangeRatio;

    private Float monthlyPriceChangeRatio;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String source;

    private OffsetDateTime publishDate;

    private Float rsi;

    private Float rs;
}
