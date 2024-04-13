package com.xstock.plutus.company;

import com.xstock.plutus.stockIndex.StockIndex;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(mappedBy="companies")
    Set<StockIndex> stockIndices;

    @Column(columnDefinition="TEXT")
    private String ticker;

    @Column(name = "com_group_code", columnDefinition="TEXT")
    private String comGroupCode;

    @Column(name = "com_type_code", columnDefinition="TEXT")
    private String comTypeCode;

    @Column(name = "organ_name", columnDefinition="TEXT")
    private String organName;

    @Column(name = "organ_short_name", columnDefinition="TEXT")
    private String organShortName;

    @Column(name = "organ_type_code", columnDefinition="TEXT")
    private String organTypeCode;

    @Column(name = "icb_name", columnDefinition="TEXT")
    private String icbName;

    @Column(name = "icb_code", columnDefinition="TEXT")
    private String icbCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getComGroupCode() {
        return comGroupCode;
    }

    public void setComGroupCode(String comGroupCode) {
        this.comGroupCode = comGroupCode;
    }

    public String getComTypeCode() {
        return comTypeCode;
    }

    public void setComTypeCode(String comTypeCode) {
        this.comTypeCode = comTypeCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOrganShortName() {
        return organShortName;
    }

    public void setOrganShortName(String organShortName) {
        this.organShortName = organShortName;
    }

    public String getOrganTypeCode() {
        return organTypeCode;
    }

    public void setOrganTypeCode(String organTypeCode) {
        this.organTypeCode = organTypeCode;
    }

    public String getIcbName() {
        return icbName;
    }

    public void setIcbName(String icbName) {
        this.icbName = icbName;
    }

    public String getIcbCode() {
        return icbCode;
    }

    public void setIcbCode(String icbCode) {
        this.icbCode = icbCode;
    }
}
