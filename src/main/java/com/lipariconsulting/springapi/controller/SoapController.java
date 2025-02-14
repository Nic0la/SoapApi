package com.lipariconsulting.springapi.controller;

import com.lipariconsulting.springapi.client.NumberConversionSoapType;
import com.lipariconsulting.springapi.service.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class SoapController {

    @Autowired
    private SoapService soapService;

    @Autowired
    private NumberConversionSoapType numberConversionSoapType;

    @GetMapping("/getCountry")
    public String getCountry(@RequestParam String country) {
        return soapService.request(country);
    }

    @GetMapping("/convertNumber")
    public String convertNumber(@RequestParam("number") int number) {
        try {
            String result = numberConversionSoapType.numberToWords(BigInteger.valueOf(number));
            return result;
        } catch (Exception e) {
            return "Error during SOAP request: " + e.getMessage();
        }
    }

}
