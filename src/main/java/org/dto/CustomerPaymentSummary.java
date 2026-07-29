package org.dto;

import java.util.Objects;

public class CustomerPaymentSummary {

    private String customerId;

    private double totalAmount;

    private long successfulPayments;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getSuccessfulPayments() {
        return successfulPayments;
    }

    public void setSuccessfulPayments(long successfulPayments) {
        this.successfulPayments = successfulPayments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomerPaymentSummary that = (CustomerPaymentSummary) o;
        return Double.compare(getTotalAmount(), that.getTotalAmount()) == 0 && getSuccessfulPayments() == that.getSuccessfulPayments() && Objects.equals(getCustomerId(), that.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getTotalAmount(), getSuccessfulPayments());
    }

    @Override
    public String toString() {
        return "CustomerPaymentSummary{" +
                "customerId='" + customerId + '\'' +
                ", totalAmount=" + totalAmount +
                ", successfulPayments=" + successfulPayments +
                '}';
    }
}
