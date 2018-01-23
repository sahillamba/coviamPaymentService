package com.coviam.payment_service.service;

import com.coviam.payment_service.repository.CardDetailsRepository;
import com.coviam.payment_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardDetailsRepository cardDetailsRepository;


}
