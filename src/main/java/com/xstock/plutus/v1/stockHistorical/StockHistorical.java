package com.xstock.plutus.v1.stockHistorical;

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
@Table(name = "stock_historical")
@IdClass(StockHistoricalId.class)
@JsonIgnoreProperties(value = {"company_id", "company"})
public class StockHistorical {
    @Id
    private int company_id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "company_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private OffsetDateTime time;

    private Integer open;

    private Integer high;

    private Integer low;

    private Integer close;

    private Integer volume;
}
