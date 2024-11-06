package com.xstock.plutus.api.v1.stock.stockHistorical;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.stock.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Entity
@IdClass(StockHistoricalId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class StockHistorical {
    @Id
    private int companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
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
