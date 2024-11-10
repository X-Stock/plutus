package com.xstock.plutus.api.v1.stock.officer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.v1.stock.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@NoArgsConstructor(force = true)
@Entity
@Table(name = "officers")
@IdClass(OfficerId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class Officer {
    @Id
    private final Integer companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Company company;

    @Id
    private final Short no;

    @Column(columnDefinition = "TEXT")
    private final String name;

    @Column(columnDefinition = "TEXT")
    private final String position;

    private final Float ownPercent;
}
