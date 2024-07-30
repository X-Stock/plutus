package com.xstock.plutus.v1.balanceSheet;

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
@Table(name = "balance_sheet", indexes = @Index(columnList = "company_id"))
public class BalanceSheet {
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

    private Integer asset;

    @Column(name = "short_asset")
    private Integer shortAsset;

    @Column(name = "fixed_asset")
    private Integer fixedAsset;

    @Column(name = "long_asset")
    private Integer longAsset;

    @Column(name = "other_asset")
    private Integer otherAsset;

    private Integer debt;

    @Column(name = "short_debt")
    private Integer shortDebt;

    @Column(name = "long_debt")
    private Integer longDebt;

    @Column(name = "other_debt")
    private Integer otherDebt;

    private Integer deposit;

    @Column(name = "central_bank_deposit")
    private Integer centralBankDeposit;

    @Column(name = "other_bank_deposit")
    private Integer otherBankDeposit;

    @Column(name = "customer_loan")
    private Integer customerLoan;

    @Column(name = "net_customer_loan")
    private Integer netCustomerLoan;

    @Column(name = "bad_loan")
    private Integer badLoan;

    @Column(name = "other_bank_loan")
    private Integer otherBankLoan;

    private Integer cash;

    @Column(name = "short_invest")
    private Integer shortInvest;

    @Column(name = "short_receivable")
    private Integer shortReceivable;

    private Integer inventory;

    private Integer equity;

    private Integer capital;

    @Column(name = "stock_invest")
    private Integer stockInvest;

    private Integer provision;

    @Column(name = "other_bank_credit")
    private Integer otherBankCredit;

    @Column(name = "owe_other_bank")
    private Integer oweOtherBank;

    @Column(name = "owe_central_bank")
    private Integer oweCentralBank;

    @Column(name = "valuable_paper")
    private Integer valuablePaper;

    @Column(name = "payable_interest")
    private Integer payableInterest;

    @Column(name = "receivable_interest")
    private Integer receivableInterest;

    private Integer fund;

    @Column(name = "un_distributed_income")
    private Integer unDistributedIncome;

    @Column(name = "minor_shareholder_profit")
    private Integer minorShareholderProfit;

    private Integer payable;
}
