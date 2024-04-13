package com.xstock.plutus.stockIndex;

import com.xstock.plutus.company.Company;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "stock_indices")
public class StockIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    Set<Company> companies;

    @Column(name = "index_name", columnDefinition="TEXT")
    private String indexName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
}
