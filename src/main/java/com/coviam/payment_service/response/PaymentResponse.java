package com.coviam.payment_service.response;

public class PaymentResponse {

    private Boolean success;
    private int status;
    private String errorMsg;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public PaymentResponse() {
    }

    public PaymentResponse(Boolean success, int status) {
        this.success = success;
        this.status = status;
    }

    public PaymentResponse(Boolean success, int status, String errorMsg) {
        this.success = success;
        this.status = status;
        this.errorMsg = errorMsg;
    }
}
