package com.xstock.plutus.v1.stockIntraday;

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
@Table(name = "stock_intraday")
@IdClass(StockIntradayId.class)
@JsonIgnoreProperties(value = {"company_id", "company"})
public class StockIntraday {
    @Id
    private int company_id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "company_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private OffsetDateTime time;

    @Column(name = "order_type", columnDefinition = "TEXT")
    private String orderType;

    private Integer volume;

    private Float price;

    @Column(name = "previous_price_change")
    private Float previousPriceChange;
}
