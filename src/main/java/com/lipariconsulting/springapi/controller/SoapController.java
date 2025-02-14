package com.lipariconsulting.springapi.controller;

import com.baeldung.springsoap.gen.GetCountryResponse;
import com.lipariconsulting.springapi.service.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SoapController {

    @Autowired
    private SoapService soapService;

    @GetMapping("/getCountry")
    public String getCountry(@RequestParam String country) {
        return soapService.request(country);
    }


}
