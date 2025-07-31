package model;

import java.math.BigDecimal;

public class Tax {
    private int taxId;
    private String taxName;
    private BigDecimal rate;

    public Tax() {} // default constructor

    public Tax(int taxId, String taxName, BigDecimal rate) {
        this.taxId = taxId;
        this.taxName = taxName;
        this.rate = rate;
    }

    // getters
    public int getTaxId() { return taxId; }
    public String getTaxName() { return taxName; }
    public BigDecimal getRate() { return rate; }

    // setters
    public void setTaxId(int taxId) { this.taxId = taxId; }
    public void setTaxName(String taxName) { this.taxName = taxName; }
    public void setRate(BigDecimal rate) { this.rate = rate; }
}
