package com.xstock.plutus.v1.cashflow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstock.plutus.v1.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cash_flow")
public class CashFlow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    private Byte quarter;

    private Short year;

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
