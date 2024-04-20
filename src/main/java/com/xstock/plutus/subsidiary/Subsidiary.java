package com.xstock.plutus.subsidiary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "subsidiaries")
public class Subsidiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(name = "own_percent")
    private Float ownPercent;
}
