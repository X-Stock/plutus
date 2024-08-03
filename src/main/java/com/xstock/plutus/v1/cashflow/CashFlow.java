package com.xstock.plutus.v1.cashflow;

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
@Table(name = "cash_flow")
@IdClass(CashFlowId.class)
@JsonIgnoreProperties(value = {"company_id", "company"})
public class CashFlow {
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

    @Column(name = "invest_cost")
    private Integer investCost;

    @Column(name = "from_invest")
    private Integer fromInvest;

    @Column(name = "from_financial")
    private Integer fromFinancial;

    @Column(name = "from_sale")
    private Integer fromSale;

    @Column(name = "free_cash_flow")
    private Integer freeCashFlow;
}
