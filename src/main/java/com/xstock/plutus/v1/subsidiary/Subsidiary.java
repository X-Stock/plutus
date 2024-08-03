package com.xstock.plutus.v1.subsidiary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@Table(name = "subsidiaries")
@IdClass(SubsidiaryId.class)
@JsonIgnoreProperties(value = {"company_id", "company"})
public class Subsidiary {
    @Id
    private int company_id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "company_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private short no;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(name = "own_percent")
    private Float ownPercent;
}
