package com.xstock.plutus.api.stock.v1.incomeStatement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.stock.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@IdClass(IncomeStatementId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class IncomeStatement {
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

    private Integer revenue;

    private Float yearRevenueGrowth;

    private Float quarterRevenueGrowth;

    private Integer costOfGoodSold;

    private Integer grossProfit;

    private Integer operationExpense;

    private Integer operationProfit;

    private Float yearOperationProfitGrowth;

    private Float quarterOperationProfitGrowth;

    private Integer interestExpense;

    private Integer preTaxProfit;

    private Integer postTaxProfit;

    private Integer shareholderIncome;

    private Float yearShareholderIncomeGrowth;

    private Float quarterShareholderIncomeGrowth;

    private Integer investProfit;

    private Integer serviceProfit;

    private Integer otherProfit;

    private Integer provisionExpense;

    private Integer operationIncome;

    private Integer ebitda;
}
