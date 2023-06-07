package ru.nsu.boxberger.divipay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentModel {
    @JsonProperty("paymentID")
    private Long paymentID;

    @JsonProperty("userID")
    private Long userID;

    @JsonProperty ("purchaseID")
    private Long purchaseID;

    public Long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Long paymentID) {
        this.paymentID = paymentID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(Long purchaseID) {
        this.purchaseID = purchaseID;
    }
}
