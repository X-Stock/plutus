package com.xstock.plutus.v1.ratio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@IdClass(RatioId.class)
@JsonIgnoreProperties(value = {"companyId", "company"})
public class Ratio {
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

    private Float priceToEarning;

    private Float priceToBook;

    private Float valueBeforeEbitda;

    private Float dividend;

    private Float roe;

    private Float roa;

    private Integer daysReceivable;

    private Integer daysInventory;

    private Integer daysPayable;

    private Float ebitOnInterest;

    private Integer earningPerShare;

    private Integer bookValuePerShare;

    private Float interestMargin;

    private Float nonInterestOnToi;

    private Float badDebtPercentage;

    private Float provisionOnBadDebt;

    private Float costOfFinancing;

    private Float equityOnTotalAsset;

    private Float equityOnLoan;

    private Float costToIncome;

    private Float equityOnLiability;

    private Float currentPayment;

    private Float quickPayment;

    private Float epsChange;

    private Integer ebitdaOnStock;

    private Float grossProfitMargin;

    private Float operatingProfitMargin;

    private Float postTaxMargin;

    private Float debtOnEquity;

    private Float debtOnAsset;

    private Float debtOnEbitda;

    private Float shortOnLongDebt;

    private Float assetOnEquity;

    private Float capitalBalance;

    private Float cashOnEquity;

    private Float cashOnCapitalize;

    private Float cashCirculation;

    private Float revenueOnWorkCapital;

    private Float capexOnFixedAsset;

    private Float revenueOnAsset;

    private Float postTaxOnPreTax;

    private Float ebitOnRevenue;

    private Float preTaxOnEbit;

    private Float preProvisionOnToi;

    private Float postTaxOnToi;

    private Float loanOnEarnAsset;

    private Float loanOnAsset;

    private Float loanOnDeposit;

    private Float depositOnEarnAsset;

    private Float badDebtOnAsset;

    private Float liquidityOnLiability;

    private Float payableOnEquity;

    private Float cancelDebt;

    private Float ebitdaOnStockChange;

    private Float bookValuePerShareChange;

    private Float creditGrowth;
}
