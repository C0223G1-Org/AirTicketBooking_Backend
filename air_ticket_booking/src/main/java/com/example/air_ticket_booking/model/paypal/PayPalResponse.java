package com.example.air_ticket_booking.model.paypal;

public class PayPalResponse {
    private String status;
    private String transactionId;
    private String payerId;
    private String paymentDate;

    public PayPalResponse(String status, String transactionId, String payerId, String paymentDate) {
        this.status = status;
        this.transactionId = transactionId;
        this.payerId = payerId;
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
