package com.xstock.plutus.api.v1.stock.stockIntraday;

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
@IdClass(StockIntradayId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class StockIntraday {
    @Id
    private final Integer companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Company company;

    @Id
    private final OffsetDateTime time;

    @Column(columnDefinition = "TEXT")
    private final String orderType;

    private final Integer volume;

    private final Float price;

    private final Float previousPriceChange;
}
