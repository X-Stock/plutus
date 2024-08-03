package com.xstock.plutus.v1.insiderDeal;

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
@Table(name = "insider_deals")
@IdClass(InsiderDealId.class)
@JsonIgnoreProperties(value = {"company_id", "company"})
public class InsiderDeal {
    @Id
    private int company_id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "company_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    @Column(name = "deal_announce_date")
    private OffsetDateTime dealAnnounceDate;

    @Column(name = "deal_method", columnDefinition = "TEXT")
    private String dealMethod;

    @Column(name = "deal_action", columnDefinition = "TEXT")
    private String dealAction;

    @Column(name = "deal_quantity")
    private Integer dealQuantity;

    @Column(name = "deal_price")
    private Integer dealPrice;

    @Column(name = "deal_ratio")
    private Float dealRatio;
}
