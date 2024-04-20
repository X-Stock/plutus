package com.xstock.plutus.insiderDeal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "insider_deals")
public class InsiderDeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

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
