package com.xstock.plutus.v1.stockIntraday;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Entity
@IdClass(StockIntradayId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class StockIntraday {
    @Id
    private int companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private OffsetDateTime time;

    @Column(columnDefinition = "TEXT")
    private String orderType;

    private Integer volume;

    private Float price;

    private Float previousPriceChange;
}
