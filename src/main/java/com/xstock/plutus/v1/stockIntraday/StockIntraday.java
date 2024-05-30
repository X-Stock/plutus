package com.xstock.plutus.v1.stockIntraday;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
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

    @Column(name = "order_type", columnDefinition = "TEXT")
    private String orderType;

    private Integer volume;

    private Float price;

    @Column(name = "previous_price_change")
    private Float previousPriceChange;
}
