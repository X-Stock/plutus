package com.xstock.plutus.v1.subsidiary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "subsidiaries",
        indexes = @Index(columnList = "company_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"no", "company_id"}))
@JsonIgnoreProperties(value = {"id", "company"})
public class Subsidiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer no;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(name = "own_percent")
    private Float ownPercent;
}
