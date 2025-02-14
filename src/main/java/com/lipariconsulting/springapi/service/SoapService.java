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
        // Crea la richiesta SOAP
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        // Invia la richiesta SOAP e ottieni la risposta
        GetCountryResponse response = (GetCountryResponse) webServiceTemplate.marshalSendAndReceive(request);

        // Elabora la risposta
        return response.getCountry().getName(); // Esempio: restituisci il nome del paese
    }


}
