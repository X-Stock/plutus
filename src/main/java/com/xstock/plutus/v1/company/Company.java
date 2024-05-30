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

    @Column(name = "com_group_code", columnDefinition = "TEXT")
    private String comGroupCode;

    @Column(name = "com_type_code", columnDefinition = "TEXT")
    private String comTypeCode;

    @Column(name = "organ_name", columnDefinition = "TEXT")
    private String organName;

    @Column(name = "organ_short_name", columnDefinition = "TEXT")
    private String organShortName;

    @Column(name = "organ_type_code", columnDefinition = "TEXT")
    private String organTypeCode;

    @Column(name = "icb_name", columnDefinition = "TEXT")
    private String icbName;

    @Column(name = "icb_code", columnDefinition = "TEXT")
    private String icbCode;
}
