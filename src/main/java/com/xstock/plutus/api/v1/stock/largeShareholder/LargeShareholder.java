package com.xstock.plutus.api.v1.stock.largeShareholder;

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
@Table(name = "large_shareholders")
@IdClass(LargeShareholderId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class LargeShareholder {
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
    private final String shareholder;

    private final Float shareOwnPercent;
}
