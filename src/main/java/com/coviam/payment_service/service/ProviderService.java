package com.coviam.payment_service.service;

import com.coviam.payment_service.model.ProviderConfig;
import com.coviam.payment_service.repository.BusinessConfigRepository;
import com.coviam.payment_service.repository.ProviderConfigRepository;
import com.coviam.payment_service.util.ProviderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    @Autowired
    ProviderConfigRepository providerConfigRepository;

    @Autowired
    BusinessConfigRepository businessConfigRepository;

    public ProviderConfig getProviderConfig(Long id) {
        return providerConfigRepository.getOne(id);
    }

    public void createProvider(String providerName,String providerUrl,String providerCallbackUrl,String providerCredentialKey1,String providerCredentialKey2,ProviderConfig.Status providerStatus) {
        ProviderConfig newProviderConfig = new ProviderConfig(providerName,providerUrl,providerCallbackUrl,providerCredentialKey1,providerCredentialKey2,providerStatus);
         providerConfigRepository.save(newProviderConfig);
    }

}
