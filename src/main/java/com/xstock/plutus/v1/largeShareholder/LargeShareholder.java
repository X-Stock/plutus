package com.xstock.plutus.v1.largeShareholder;

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
@Table(name = "large_shareholders")
@IdClass(LargeShareholderId.class)
@JsonIgnoreProperties(value = {"company_id", "company"})
public class LargeShareholder {
    @Id
    private int company_id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "company_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private short no;

    @Column(columnDefinition = "TEXT")
    private String shareholder;

    @Column(name = "share_own_percent")
    private Float shareOwnPercent;
}
