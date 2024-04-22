package com.xstock.plutus.v1.stockIndex;

import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "stock_indices")
public class StockIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    Set<Company> companies;

    @Column(name = "index_name", columnDefinition = "TEXT")
    private String indexName;
}
