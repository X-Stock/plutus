package com.xstock.plutus.v1.ratio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ratio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    private Byte quarter;

    private Short year;

    @Column(name = "price_to_earning")
    private Double priceToEarning;

    @Column(name = "price_to_book")
    private Double priceToBook;

    @Column(name = "value_before_ebitda")
    private Double valueBeforeEbitda;

    private Double dividend;

    private Double roe;

    private Double roa;

    @Column(name = "days_receivable")
    private Integer daysReceivable;

    @Column(name = "days_inventory")
    private Integer daysInventory;

    @Column(name = "days_payable")
    private Integer daysPayable;

    @Column(name = "ebit_on_interest")
    private Double ebitOnInterest;

    @Column(name = "earning_per_share")
    private Integer earningPerShare;

    @Column(name = "book_value_per_share")
    private Integer bookValuePerShare;

    @Column(name = "interest_margin")
    private Double interestMargin;

    @Column(name = "non_interest_on_toi")
    private Double nonInterestOnToi;

    @Column(name = "bad_debt_percentage")
    private Double badDebtPercentage;

    @Column(name = "provision_on_bad_debt")
    private Double provisionOnBadDebt;

    @Column(name = "cost_of_financing")
    private Double costOfFinancing;

    @Column(name = "equity_on_total_asset")
    private Double equityOnTotalAsset;

    @Column(name = "equity_on_loan")
    private Double equityOnLoan;

    @Column(name = "cost_to_income")
    private Double costToIncome;

    @Column(name = "equity_on_liability")
    private Double equityOnLiability;

    @Column(name = "current_payment")
    private Double currentPayment;

    @Column(name = "quick_payment")
    private Double quickPayment;

    @Column(name = "eps_change")
    private Double epsChange;

    @Column(name = "ebitda_on_stock")
    private Integer ebitdaOnStock;

    @Column(name = "gross_profit_margin")
    private Double grossProfitMargin;

    @Column(name = "operating_profit_margin")
    private Double operatingProfitMargin;

    @Column(name = "post_tax_margin")
    private Double postTaxMargin;

    @Column(name = "debt_on_equity")
    private Double debtOnEquity;

    @Column(name = "debt_on_asset")
    private Double debtOnAsset;

    @Column(name = "debt_on_ebitda")
    private Double debtOnEbitda;

    @Column(name = "short_on_long_debt")
    private Double shortOnLongDebt;

    @Column(name = "asset_on_equity")
    private Double assetOnEquity;

    @Column(name = "capital_balance")
    private Double capitalBalance;

    @Column(name = "cash_on_equity")
    private Double cashOnEquity;

    @Column(name = "cash_on_capitalize")
    private Double cashOnCapitalize;

    @Column(name = "cash_circulation")
    private Double cashCirculation;

    @Column(name = "revenue_on_work_capital")
    private Double revenueOnWorkCapital;

    @Column(name = "capex_on_fixed_asset")
    private Double capexOnFixedAsset;

    @Column(name = "revenue_on_asset")
    private Double revenueOnAsset;

    @Column(name = "post_tax_on_pre_tax")
    private Double postTaxOnPreTax;

    @Column(name = "ebit_on_revenue")
    private Double ebitOnRevenue;

    @Column(name = "pre_tax_on_ebit")
    private Double preTaxOnEbit;

    @Column(name = "pre_provision_on_toi")
    private Double preProvisionOnToi;

    @Column(name = "post_tax_on_toi")
    private Double postTaxOnToi;

    @Column(name = "loan_on_earn_asset")
    private Double loanOnEarnAsset;

    @Column(name = "loan_on_asset")
    private Double loanOnAsset;

    @Column(name = "loan_on_deposit")
    private Double loanOnDeposit;

    @Column(name = "deposit_on_earn_asset")
    private Double depositOnEarnAsset;

    @Column(name = "bad_debt_on_asset")
    private Double badDebtOnAsset;

    @Column(name = "liquidity_on_liability")
    private Double liquidityOnLiability;

    @Column(name = "payable_on_equity")
    private Double payableOnEquity;

    @Column(name = "cancel_debt")
    private Double cancelDebt;

    @Column(name = "ebitda_on_stock_change")
    private Double ebitdaOnStockChange;

    @Column(name = "book_value_per_share_change")
    private Double bookValuePerShareChange;

    @Column(name = "credit_growth")
    private Double creditGrowth;
}
