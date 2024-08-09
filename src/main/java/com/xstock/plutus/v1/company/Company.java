package com.xstock.plutus.v1.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.stockIndex.StockIndex;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Getter
@Entity
@Table(name = "companies", indexes = @Index(columnList = "ticker", unique = true))
@JsonIgnoreProperties(value = {"id", "stockIndices"})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(mappedBy = "company")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<StockIndex> stockIndices;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String ticker;

    @Column(columnDefinition = "TEXT")
    private String fullnameVi;

    private Integer companyType;

    @Column(columnDefinition = "TEXT")
    private String exchange;
}
