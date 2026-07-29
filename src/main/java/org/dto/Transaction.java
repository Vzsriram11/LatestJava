package org.dto;


import java.util.Objects;

public class Transaction {
private float amount;
    private String status;

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isHighRiskLocation() {
        if (!Objects.equals(this.country, "Nigeria")) {
            return  false;
        } else {
            return true;
        }
    }
}
