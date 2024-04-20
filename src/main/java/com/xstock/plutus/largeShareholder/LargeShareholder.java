package com.xstock.plutus.largeShareholder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "large_shareholders")
public class LargeShareholder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @Column(columnDefinition = "TEXT")
    private String shareholder;

    @Column(name = "share_own_percent")
    private Float shareOwnPercent;
}
