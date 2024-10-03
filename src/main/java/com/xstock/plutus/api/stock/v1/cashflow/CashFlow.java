package com.xstock.plutus.api.stock.v1.cashflow;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.stock.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@IdClass(CashFlowId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class CashFlow {
    @Id
    private Integer companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private Short quarter;

    @Id
    private Short year;

    private Integer investCost;

    private Integer fromInvest;

    private Integer fromFinancial;

    private Integer fromSale;

    private Integer freeCashFlow;
}
