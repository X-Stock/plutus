package com.xstock.plutus.v1.ratio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(indexes = @Index(columnList = "company_id"))
public class Ratio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Company company;

    private Byte quarter;

    private Short year;

    @Column(name = "price_to_earning")
    private Float priceToEarning;

    @Column(name = "price_to_book")
    private Float priceToBook;

    @Column(name = "value_before_ebitda")
    private Float valueBeforeEbitda;

    private Float dividend;

    private Float roe;

    private Float roa;

    @Column(name = "days_receivable")
    private Integer daysReceivable;

    @Column(name = "days_inventory")
    private Integer daysInventory;

    @Column(name = "days_payable")
    private Integer daysPayable;

    @Column(name = "ebit_on_interest")
    private Float ebitOnInterest;

    @Column(name = "earning_per_share")
    private Integer earningPerShare;

    @Column(name = "book_value_per_share")
    private Integer bookValuePerShare;

    @Column(name = "interest_margin")
    private Float interestMargin;

    @Column(name = "non_interest_on_toi")
    private Float nonInterestOnToi;

    @Column(name = "bad_debt_percentage")
    private Float badDebtPercentage;

    @Column(name = "provision_on_bad_debt")
    private Float provisionOnBadDebt;

    @Column(name = "cost_of_financing")
    private Float costOfFinancing;

    @Column(name = "equity_on_total_asset")
    private Float equityOnTotalAsset;

    @Column(name = "equity_on_loan")
    private Float equityOnLoan;

    @Column(name = "cost_to_income")
    private Float costToIncome;

    @Column(name = "equity_on_liability")
    private Float equityOnLiability;

    @Column(name = "current_payment")
    private Float currentPayment;

    @Column(name = "quick_payment")
    private Float quickPayment;

    @Column(name = "eps_change")
    private Float epsChange;

    @Column(name = "ebitda_on_stock")
    private Integer ebitdaOnStock;

    @Column(name = "gross_profit_margin")
    private Float grossProfitMargin;

    @Column(name = "operating_profit_margin")
    private Float operatingProfitMargin;

    @Column(name = "post_tax_margin")
    private Float postTaxMargin;

    @Column(name = "debt_on_equity")
    private Float debtOnEquity;

    @Column(name = "debt_on_asset")
    private Float debtOnAsset;

    @Column(name = "debt_on_ebitda")
    private Float debtOnEbitda;

    @Column(name = "short_on_long_debt")
    private Float shortOnLongDebt;

    @Column(name = "asset_on_equity")
    private Float assetOnEquity;

    @Column(name = "capital_balance")
    private Float capitalBalance;

    @Column(name = "cash_on_equity")
    private Float cashOnEquity;

    @Column(name = "cash_on_capitalize")
    private Float cashOnCapitalize;

    @Column(name = "cash_circulation")
    private Float cashCirculation;

    @Column(name = "revenue_on_work_capital")
    private Float revenueOnWorkCapital;

    @Column(name = "capex_on_fixed_asset")
    private Float capexOnFixedAsset;

    @Column(name = "revenue_on_asset")
    private Float revenueOnAsset;

    @Column(name = "post_tax_on_pre_tax")
    private Float postTaxOnPreTax;

    @Column(name = "ebit_on_revenue")
    private Float ebitOnRevenue;

    @Column(name = "pretax_on_ebit")
    private Float preTaxOnEbit;

    @Column(name = "pre_provision_on_toi")
    private Float preProvisionOnToi;

    @Column(name = "post_tax_on_toi")
    private Float postTaxOnToi;

    @Column(name = "loan_on_earn_asset")
    private Float loanOnEarnAsset;

    @Column(name = "loan_on_asset")
    private Float loanOnAsset;

    @Column(name = "loan_on_deposit")
    private Float loanOnDeposit;

    @Column(name = "deposit_on_earn_asset")
    private Float depositOnEarnAsset;

    @Column(name = "bad_debt_on_asset")
    private Float badDebtOnAsset;

    @Column(name = "liquidity_on_liability")
    private Float liquidityOnLiability;

    @Column(name = "payable_on_equity")
    private Float payableOnEquity;

    @Column(name = "cancel_debt")
    private Float cancelDebt;

    @Column(name = "ebitda_on_stock_change")
    private Float ebitdaOnStockChange;

    @Column(name = "book_value_per_share_change")
    private Float bookValuePerShareChange;

    @Column(name = "credit_growth")
    private Float creditGrowth;
}
