package com.lipariconsulting.springapi.controller;

import com.lipariconsulting.springapi.client.NumberConversionSoapType;
import com.lipariconsulting.springapi.service.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class SoapController {


    //private final SoapService soapService;


    private final NumberConversionSoapType numberConversionSoapType;

    public SoapController(NumberConversionSoapType numberConversionSoapType) {
        this.numberConversionSoapType = numberConversionSoapType;
    }



//    @GetMapping("/getCountry")
//    public String getCountry(@RequestParam String country) {
//        return soapService.request(country);
//    }


    @GetMapping("/convertNumberToWords")
    public String convertNumberToWords(@RequestParam("number") int number) {
        return numberConversionSoapType.numberToWords(BigInteger.valueOf(number));
    }


}
