package com.xstock.plutus.api.v1.stock.insiderDeal;

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
@Table(name = "insider_deals")
@IdClass(InsiderDealId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class InsiderDeal {
    @Id
    private final Integer companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Company company;

    @Id
    private final OffsetDateTime dealAnnounceDate;

    @Column(columnDefinition = "TEXT")
    private final String dealMethod;

    @Column(columnDefinition = "TEXT")
    private final String dealAction;

    private final Integer dealQuantity;

    private final Integer dealPrice;

    private final Float dealRatio;
}
