package com.xstock.plutus.v1.incomeStatement;

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
@Table(name = "income_statement")
@IdClass(IncomeStatementId.class)
@JsonIgnoreProperties(value = {"company_id", "company"})
public class IncomeStatement {
    @Id
    private int company_id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "company_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Id
    private short quarter;

    @Id
    private short year;

    private Integer revenue;

    @Column(name = "year_revenue_growth")
    private Float yearRevenueGrowth;

    @Column(name = "quarter_revenue_growth")
    private Float quarterRevenueGrowth;

    @Column(name = "cost_of_good_sold")
    private Integer costOfGoodSold;

    @Column(name = "gross_profit")
    private Integer grossProfit;

    @Column(name = "operation_expense")
    private Integer operationExpense;

    @Column(name = "operation_profit")
    private Integer operationProfit;

    @Column(name = "year_operation_profit_growth")
    private Float yearOperationProfitGrowth;

    @Column(name = "quarter_operation_profit_growth")
    private Float quarterOperationProfitGrowth;

    @Column(name = "interest_expense")
    private Integer interestExpense;

    @Column(name = "pre_tax_profit")
    private Integer preTaxProfit;

    @Column(name = "post_tax_profit")
    private Integer postTaxProfit;

    @Column(name = "shareholder_income")
    private Integer shareholderIncome;

    @Column(name = "year_shareholder_income_growth")
    private Float yearShareholderIncomeGrowth;

    @Column(name = "quarter_shareholder_income_growth")
    private Float quarterShareholderIncomeGrowth;

    @Column(name = "invest_profit")
    private Integer investProfit;

    @Column(name = "service_profit")
    private Integer serviceProfit;

    @Column(name = "other_profit")
    private Integer otherProfit;

    @Column(name = "provision_expense")
    private Integer provisionExpense;

    @Column(name = "operation_income")
    private Integer operationIncome;

    private Integer ebitda;
}
