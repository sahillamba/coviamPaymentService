package com.coviam.payment_service.request;


import com.coviam.payment_service.model.CardDetails;

public class ProcessPaymentRequest {
    private String itnId;
    private String amount;
    private String providerId;
    private String paymentMethod;
    private String customerId;
    private Boolean overRideFlag;
    private CardDetails cardDetails;

    public String getItnId() {
        return itnId;
    }

    public void setItnId(String itnId) {
        this.itnId = itnId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Boolean getOverRideFlag() {
        return overRideFlag;
    }

    public void setOverRideFlag(Boolean overRideFlag) {
        this.overRideFlag = overRideFlag;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    public ProcessPaymentRequest() {
    }

    public ProcessPaymentRequest(String itnId, String amount, String providerId, String paymentMethod, String customerId, Boolean overRideFlag, CardDetails cardDetails) {
        this.itnId = itnId;
        this.amount = amount;
        this.providerId = providerId;
        this.paymentMethod = paymentMethod;
        this.customerId = customerId;
        this.overRideFlag = overRideFlag;
        this.cardDetails = cardDetails;
    }
}
