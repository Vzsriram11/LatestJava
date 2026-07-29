package org.dto;

import org.util.Utilities;

public class Payment {

    private String paymentId;
    private String customerId;
    private double amount;
    private Utilities.PaymentStatus status; // SUCCESS, FAILED, PENDING
    private Utilities.PaymentMethod paymentMethod; // CARD, UPI, BANK_TRANSFER

    // constructors

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Utilities.PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(Utilities.PaymentStatus status) {
        this.status = status;
    }

    public Utilities.PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Utilities.PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    // getters
    // setters

    public Payment(String paymentId, String customerId, double amount, Utilities.PaymentStatus status, Utilities.PaymentMethod paymentMethod) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.amount = amount;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }
}
