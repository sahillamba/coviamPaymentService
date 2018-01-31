package com.coviam.payment_service.response;

public class ProcessPaymentResponse {
    private boolean success;

    private int status;

    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ProcessPaymentResponse() {
    }

    public ProcessPaymentResponse(boolean success, int status) {
        this.success = success;
        this.status = status;
    }

    public ProcessPaymentResponse(boolean success, int status, String errorMessage) {
        this.success = success;
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
