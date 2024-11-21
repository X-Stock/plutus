package com.xstock.plutus.api.v1.stock.cashFlow;

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
@IdClass(CashFlowId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class CashFlow {
    @Id
    private final Integer companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Company company;

    @Id
    private final Short quarter;

    @Id
    private final Short year;

    private final Integer investCost;

    private final Integer fromInvest;

    private final Integer fromFinancial;

    private final Integer fromSale;

    private final Integer freeCashFlow;
}
