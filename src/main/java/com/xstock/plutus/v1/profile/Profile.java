package com.xstock.plutus.v1.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(indexes = @Index(columnList = "company_id"))
@JsonIgnoreProperties(value = {"id", "company"})
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
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
