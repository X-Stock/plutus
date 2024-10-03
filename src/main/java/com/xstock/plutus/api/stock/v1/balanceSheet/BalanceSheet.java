package com.xstock.plutus.api.stock.v1.balanceSheet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.api.stock.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@IdClass(BalanceSheetId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class BalanceSheet {
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

    private Integer asset;

    private Integer shortAsset;

    private Integer fixedAsset;

    private Integer longAsset;

    private Integer otherAsset;

    private Integer debt;

    private Integer shortDebt;

    private Integer longDebt;

    private Integer otherDebt;

    private Integer deposit;

    private Integer centralBankDeposit;

    private Integer otherBankDeposit;

    private Integer customerLoan;

    private Integer netCustomerLoan;

    private Integer badLoan;

    private Integer otherBankLoan;

    private Integer cash;

    private Integer shortInvest;

    private Integer shortReceivable;

    private Integer inventory;

    private Integer equity;

    private Integer capital;

    private Integer stockInvest;

    private Integer provision;

    private Integer otherBankCredit;

    private Integer oweOtherBank;

    private Integer oweCentralBank;

    private Integer valuablePaper;

    private Integer payableInterest;

    private Integer receivableInterest;

    private Integer fund;

    private Integer unDistributedIncome;

    private Integer minorShareholderProfit;

    private Integer payable;
}
