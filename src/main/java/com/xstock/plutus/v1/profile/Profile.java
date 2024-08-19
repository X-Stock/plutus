package com.xstock.plutus.v1.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@JsonIgnoreProperties(value = {"companyId", "company"})
public class Profile {
    @Id
    private int companyId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Column(columnDefinition = "TEXT")
    private String companyName;

    @Column(columnDefinition = "TEXT")
    private String profile;

    @Column(columnDefinition = "TEXT")
    private String historyDev;

    @Column(columnDefinition = "TEXT")
    private String promise;

    @Column(columnDefinition = "TEXT")
    private String businessRisk;

    @Column(columnDefinition = "TEXT")
    private String keyDevelopments;

    @Column(columnDefinition = "TEXT")
    private String businessStrategies;
}
