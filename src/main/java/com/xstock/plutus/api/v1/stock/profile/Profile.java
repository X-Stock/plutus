package com.xstock.plutus.api.v1.stock.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.stock.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@NoArgsConstructor(force = true)
@Entity
@JsonIgnoreProperties(value = {"companyId", "company"})
public class Profile {
    @Id
    private final Integer companyId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Company company;

    @Column(columnDefinition = "TEXT")
    private final String companyName;

    @Column(columnDefinition = "TEXT")
    private final String profile;

    @Column(columnDefinition = "TEXT")
    private final String historyDev;

    @Column(columnDefinition = "TEXT")
    private final String promise;

    @Column(columnDefinition = "TEXT")
    private final String businessRisk;

    @Column(columnDefinition = "TEXT")
    private final String keyDevelopments;

    @Column(columnDefinition = "TEXT")
    private final String businessStrategies;
}
