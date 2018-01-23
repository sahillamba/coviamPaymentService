package com.coviam.payment_service.routes;

import com.coviam.payment_service.model.ProviderConfig;
import com.coviam.payment_service.service.ProviderService;
import com.coviam.payment_service.util.ProviderStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class ConfigRoutes {

    @Autowired
    ProviderService providerService;

    @RequestMapping(
            value = "/createProvider",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void createProvider(@RequestBody ObjectNode json) {
        providerService.createProvider(json.get("providerName").asText(),json.get("providerUrl").asText(),json.get("providerCallbackUrl").asText() , json.get("providerCredentialKey1").asText(),json.get("providerCredentialKey2").asText(), ProviderConfig.Status.active);
    }


    @RequestMapping(
            value = "/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProviderConfig getProvider(@PathVariable("id") Long id) {
        return providerService.getProviderConfig(id);
    }

}
