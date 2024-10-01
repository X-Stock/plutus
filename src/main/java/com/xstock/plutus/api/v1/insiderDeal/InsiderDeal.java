package com.xstock.plutus.api.v1.insiderDeal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Entity
@Table(name = "insider_deals")
@IdClass(InsiderDealId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class InsiderDeal {
    @Id
    private int companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private OffsetDateTime dealAnnounceDate;

    @Column(columnDefinition = "TEXT")
    private String dealMethod;

    @Column(columnDefinition = "TEXT")
    private String dealAction;

    private Integer dealQuantity;

    private Integer dealPrice;

    private Float dealRatio;
}
