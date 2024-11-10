package com.xstock.plutus.api.v1.stock.incomeStatement;

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
@IdClass(IncomeStatementId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class IncomeStatement {
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

    private final Integer revenue;

    private final Float yearRevenueGrowth;

    private final Float quarterRevenueGrowth;

    private final Integer costOfGoodSold;

    private final Integer grossProfit;

    private final Integer operationExpense;

    private final Integer operationProfit;

    private final Float yearOperationProfitGrowth;

    private final Float quarterOperationProfitGrowth;

    private final Integer interestExpense;

    private final Integer preTaxProfit;

    private final Integer postTaxProfit;

    private final Integer shareholderIncome;

    private final Float yearShareholderIncomeGrowth;

    private final Float quarterShareholderIncomeGrowth;

    private final Integer investProfit;

    private final Integer serviceProfit;

    private final Integer otherProfit;

    private final Integer provisionExpense;

    private final Integer operationIncome;

    private final Integer ebitda;
}
