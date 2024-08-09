package com.xstock.plutus.v1.largeShareholder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@Table(name = "large_shareholders")
@IdClass(LargeShareholderId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class LargeShareholder {
    @Id
    private Integer companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private Short no;

    @Column(columnDefinition = "TEXT")
    private String shareholder;

    private Float shareOwnPercent;
}
