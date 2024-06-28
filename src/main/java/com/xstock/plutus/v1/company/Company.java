package com.xstock.plutus.v1.company;

import com.xstock.plutus.v1.stockIndex.StockIndex;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "companies", indexes = @Index(columnList = "ticker", unique = true))
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(mappedBy = "companies")
    Set<StockIndex> stockIndices;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String ticker;

    @Column(name = "fullname_vi", columnDefinition = "TEXT")
    private String fullNameVi;

    @Column(name = "company_type")
    private Integer companyType;

    @Column(columnDefinition = "TEXT")
    private String exchange;
}
