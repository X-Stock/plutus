package com.xstock.plutus.stock_indies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock_indies {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private String indice_name;

    public String getIndice_name() {
        return indice_name;
    }

    public void setIndice_name(String indice_name) {
        this.indice_name = indice_name;
    }
}
