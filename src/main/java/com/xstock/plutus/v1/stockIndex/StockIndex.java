package com.xstock.plutus.v1.stockIndex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table(name = "stock_indices")
@JsonIgnoreProperties(value = {"id"})
public class StockIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    private Set<Company> company;

    @Column(name = "index_name", columnDefinition = "TEXT", nullable = false)
    private String indexName;
}
