package org.dto;

import java.util.Objects;

public class Stock {

    private String symbol;
    private String companyName;
    private String sector;
    private Double allocation;

    public Stock(String symbol, String companyName, String sector, Double allocation) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.sector = sector;
        this.allocation = allocation;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Double getAllocation() {
        return allocation;
    }

    public void setAllocation(Double allocation) {
        this.allocation = allocation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(getSymbol(), stock.getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSymbol());
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", companyName='" + companyName + '\'' +
                ", sector='" + sector + '\'' +
                ", allocation='" + allocation + '\'' +
                '}';
    }
}
