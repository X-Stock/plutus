package com.xstock.plutus.v1.largeShareholder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "large_shareholders", uniqueConstraints = @UniqueConstraint(columnNames = {"no", "company_id"}) )
public class LargeShareholder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private Integer no;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Company company;

    @Column(columnDefinition = "TEXT")
    private String shareholder;

    @Column(name = "share_own_percent")
    private Float shareOwnPercent;
}
