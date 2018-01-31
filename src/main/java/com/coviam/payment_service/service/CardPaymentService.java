package com.coviam.payment_service.service;

import com.coviam.payment_service.model.CardDetails;
import com.coviam.payment_service.model.ProviderConfig;
import com.coviam.payment_service.response.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public interface CardPaymentService {

    PaymentResponse pay(CardDetails cardDetails, Boolean overRideFlag, ProviderConfig providerConfig);

}
