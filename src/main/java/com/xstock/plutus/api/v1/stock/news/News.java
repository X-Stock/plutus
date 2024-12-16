package com.xstock.plutus.api.v1.stock.news;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.stock.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@NoArgsConstructor(force = true)
@Entity
@Table(indexes = @Index(columnList = "companyId"))
@JsonIgnoreProperties(value = {"company"})
public class News {
    @Id
    private final Long id;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Company company;

    private final Integer price;

    private final Integer priceChange;

    private final Float weeklyPriceChangeRatio;

    private final Float monthlyPriceChangeRatio;

    @Column(columnDefinition = "TEXT")
    private final String title;

    @Column(columnDefinition = "TEXT")
    private final String source;

    private final OffsetDateTime publishDate;

    private final Float rsi;

    private final Float rs;
}
