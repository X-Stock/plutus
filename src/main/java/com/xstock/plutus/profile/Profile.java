package com.xstock.plutus.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @Column(name = "companyName", columnDefinition = "TEXT")
    private String companyName;

    @Column(columnDefinition = "TEXT")
    private String profile;

    @Column(columnDefinition = "TEXT")
    private String historyDev;

    @Column(columnDefinition = "TEXT")
    private String promise;

    @Column(name = "business_risk", columnDefinition = "TEXT")
    private String businessRisk;

    @Column(name = "key_developments", columnDefinition = "TEXT")
    private String keyDevelopments;

    @Column(name = "business_strategies", columnDefinition = "TEXT")
    private String businessStrategies;
}
