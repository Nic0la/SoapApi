package com.lipariconsulting.springapi.service;

import com.baeldung.springsoap.gen.GetCountryRequest;
import com.baeldung.springsoap.gen.GetCountryResponse;
import com.lipariconsulting.springapi.config.SoapClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapService {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public String request(String country) {
        // Create the SOAP request
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        // Send the SOAP request and get the response
        GetCountryResponse response = (GetCountryResponse) webServiceTemplate.marshalSendAndReceive(request);

        // Process the response
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("Country:");
        responseBuilder.append(response.getCountry().getName());
        responseBuilder.append(" People:");
        responseBuilder.append(response.getCountry().getPopulation() + " Capital ");
        responseBuilder.append(response.getCountry().getCapital());
        responseBuilder.append(" Currency:");
        responseBuilder.append(response.getCountry().getCurrency());

        return responseBuilder.toString();
    }


}
