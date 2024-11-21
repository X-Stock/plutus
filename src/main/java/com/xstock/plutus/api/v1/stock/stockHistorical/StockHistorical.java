package com.xstock.plutus.api.v1.stock.stockHistorical;

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
@IdClass(StockHistoricalId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class StockHistorical {
    @Id
    private final Integer companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Company company;

    @Id
    private final OffsetDateTime time;

    private final Integer open;

    private final Integer high;

    private final Integer low;

    private final Integer close;

    private final Integer volume;
}
