package com.xstock.plutus.api.v1.stock.balanceSheet;

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
@IdClass(BalanceSheetId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class BalanceSheet {
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

    private final Integer asset;

    private final Integer shortAsset;

    private final Integer fixedAsset;

    private final Integer longAsset;

    private final Integer otherAsset;

    private final Integer debt;

    private final Integer shortDebt;

    private final Integer longDebt;

    private final Integer otherDebt;

    private final Integer deposit;

    private final Integer centralBankDeposit;

    private final Integer otherBankDeposit;

    private final Integer customerLoan;

    private final Integer netCustomerLoan;

    private final Integer badLoan;

    private final Integer otherBankLoan;

    private final Integer cash;

    private final Integer shortInvest;

    private final Integer shortReceivable;

    private final Integer inventory;

    private final Integer equity;

    private final Integer capital;

    private final Integer stockInvest;

    private final Integer provision;

    private final Integer otherBankCredit;

    private final Integer oweOtherBank;

    private final Integer oweCentralBank;

    private final Integer valuablePaper;

    private final Integer payableInterest;

    private final Integer receivableInterest;

    private final Integer fund;

    private final Integer unDistributedIncome;

    private final Integer minorShareholderProfit;

    private final Integer payable;
}
