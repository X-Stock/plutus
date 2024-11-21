package com.xstock.plutus.api.v1.stock.ratio;

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
@IdClass(RatioId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class Ratio {
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

    private final Float priceToEarning;

    private final Float priceToBook;

    private final Float valueBeforeEbitda;

    private final Float dividend;

    private final Float roe;

    private final Float roa;

    private final Integer daysReceivable;

    private final Integer daysInventory;

    private final Integer daysPayable;

    private final Float ebitOnInterest;

    private final Integer earningPerShare;

    private final Integer bookValuePerShare;

    private final Float interestMargin;

    private final Float nonInterestOnToi;

    private final Float badDebtPercentage;

    private final Float provisionOnBadDebt;

    private final Float costOfFinancing;

    private final Float equityOnTotalAsset;

    private final Float equityOnLoan;

    private final Float costToIncome;

    private final Float equityOnLiability;

    private final Float currentPayment;

    private final Float quickPayment;

    private final Float epsChange;

    private final Integer ebitdaOnStock;

    private final Float grossProfitMargin;

    private final Float operatingProfitMargin;

    private final Float postTaxMargin;

    private final Float debtOnEquity;

    private final Float debtOnAsset;

    private final Float debtOnEbitda;

    private final Float shortOnLongDebt;

    private final Float assetOnEquity;

    private final Float capitalBalance;

    private final Float cashOnEquity;

    private final Float cashOnCapitalize;

    private final Float cashCirculation;

    private final Float revenueOnWorkCapital;

    private final Float capexOnFixedAsset;

    private final Float revenueOnAsset;

    private final Float postTaxOnPreTax;

    private final Float ebitOnRevenue;

    private final Float preTaxOnEbit;

    private final Float preProvisionOnToi;

    private final Float postTaxOnToi;

    private final Float loanOnEarnAsset;

    private final Float loanOnAsset;

    private final Float loanOnDeposit;

    private final Float depositOnEarnAsset;

    private final Float badDebtOnAsset;

    private final Float liquidityOnLiability;

    private final Float payableOnEquity;

    private final Float cancelDebt;

    private final Float ebitdaOnStockChange;

    private final Float bookValuePerShareChange;

    private final Float creditGrowth;
}
