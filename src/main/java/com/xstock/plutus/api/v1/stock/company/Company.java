package com.xstock.plutus.api.v1.stock.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.stock.stockIndex.StockIndex;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Getter
@NoArgsConstructor(force = true)
@Entity
@Table(name = "companies", indexes = @Index(columnList = "ticker", unique = true))
@JsonIgnoreProperties(value = {"id", "stockIndices"})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id;

    @ManyToMany(mappedBy = "company")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Set<StockIndex> stockIndices;

    @Column(columnDefinition = "TEXT", nullable = false)
    private final String ticker;

    @Column(columnDefinition = "TEXT")
    private final String fullnameVi;

    private final Integer companyType;

    @Column(columnDefinition = "TEXT")
    private final String exchange;
}
