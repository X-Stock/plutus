package com.xstock.plutus.api.v1.stock.stockIndex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.stock.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor(force = true)
@Entity
@Table(name = "stock_indices")
@JsonIgnoreProperties(value = {"id"})
public class StockIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id;

    @ManyToMany
    private final Set<Company> company;

    @Column(columnDefinition = "TEXT", nullable = false)
    private final String indexName;
}
