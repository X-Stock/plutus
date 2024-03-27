package com.xstock.plutus.stockIntraday;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name="stock_intraday")
public class StockIntraday {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="company_id")
    private Integer companyId;

    private OffsetDateTime time;

    @Column(name="order_type")
    private String orderType;

    private Integer volume;

    private Float price;

    @Column(name="previous_price_change")
    private Float previousPriceChange;
}
