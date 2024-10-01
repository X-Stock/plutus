package com.xstock.plutus.api.v1.subsidiary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@Table(name = "subsidiaries")
@IdClass(SubsidiaryId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class Subsidiary {
    @Id
    private Integer companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private Short no;

    @Column(columnDefinition = "TEXT")
    private String name;

    private Float ownPercent;
}
