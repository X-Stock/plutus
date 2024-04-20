package com.xstock.plutus.v1.officer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "officers")
public class Officer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String position;

    @Column(name = "own_percent")
    private Float ownPercent;
}
