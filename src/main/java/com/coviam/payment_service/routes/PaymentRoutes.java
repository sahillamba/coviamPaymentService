package com.coviam.payment_service.routes;

import com.coviam.payment_service.model.ProviderConfig;
import com.coviam.payment_service.request.ProcessPaymentRequest;
import com.coviam.payment_service.response.PaymentResponse;
import com.coviam.payment_service.response.ProcessPaymentResponse;
import com.coviam.payment_service.service.TransactionService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRoutes {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(
            value = "/processPayment",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ProcessPaymentResponse processPayment(@RequestBody ProcessPaymentRequest request) {
        ProcessPaymentResponse response = transactionService.processPayment(request);
        return response;
    }
}
