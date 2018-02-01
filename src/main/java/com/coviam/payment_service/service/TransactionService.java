package com.coviam.payment_service.service;

import com.coviam.payment_service.model.CardDetails;
import com.coviam.payment_service.model.ProviderConfig;
import com.coviam.payment_service.model.Transaction;
import com.coviam.payment_service.repository.CardDetailsRepository;
import com.coviam.payment_service.repository.TransactionRepository;
import com.coviam.payment_service.request.ProcessPaymentRequest;
import com.coviam.payment_service.request.UpdateBookingPaymentRequest;
import com.coviam.payment_service.response.PaymentResponse;
import com.coviam.payment_service.response.ProcessPaymentResponse;
import com.coviam.payment_service.util.HttpUtility;
import com.coviam.payment_service.util.JsonHelper;
import com.coviam.payment_service.util.RandomGenerator;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardDetailsRepository cardDetailsRepository;

    @Autowired
    RandomGenerator randomGenerator;

    @Autowired
    ProviderService providerService;

    @Autowired
    CardPaymentServiceImpl cardPaymentService;

    @Autowired
    JsonHelper jsonHelper;

    public ProcessPaymentResponse processPayment(ProcessPaymentRequest request){

        ProcessPaymentResponse processPaymentResponse;

        ProviderConfig providerConfig = providerService.getProviderConfig(Long.valueOf(request.getProviderId()));
        PaymentResponse paymentResponse = cardPaymentService.pay(request.getCardDetails(),request.getOverRideFlag(),providerConfig);

        Transaction.Status paymentStatus;
        final String uri;
        if(paymentResponse.getSuccess()){
            paymentStatus = Transaction.Status.success;
            uri = "http://localhost:8091/booking/updateBookingPaymentSuccessful";
        }else{
            paymentStatus = Transaction.Status.deferred;
            uri = "http://localhost:8091/booking/updateBookingPaymentError";
        }

        Transaction newTransaction = new Transaction(randomGenerator.generateRandomString(),request.getItnId(),request.getAmount(),request.getProviderId(),request.getPaymentMethod(), paymentStatus,request.getCustomerId());
        newTransaction.setCardDetails(request.getCardDetails());
        Transaction savedTransaction = transactionRepository.save(newTransaction);

        UpdateBookingPaymentRequest requestObj = new UpdateBookingPaymentRequest(savedTransaction.getItnId(),savedTransaction.getTxnId());

        if(paymentResponse.getSuccess()){
            JSONObject jsonResponse =  new JSONObject(HttpUtility.service_AppJSON(uri,1, jsonHelper.getJSONObject(requestObj)));

            if ( jsonResponse.getString("success") == "true") {
                processPaymentResponse = new ProcessPaymentResponse(true, Integer.parseInt(jsonResponse.getString("status")));

            } else {
                processPaymentResponse = new ProcessPaymentResponse(false, Integer.parseInt(jsonResponse.getString("status")),"Failed While Updating Booking");

            }
        }else{
            processPaymentResponse = new ProcessPaymentResponse(paymentResponse.getSuccess(),  paymentResponse.getStatus(),paymentResponse.getErrorMsg());
        }

        return processPaymentResponse;
    }
}
