package com.lipariconsulting.springapi.model.repository;


import com.baeldung.springsoap.gen.Country;
import com.baeldung.springsoap.gen.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        //Write here the data
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46733038);

        countries.put(spain.getName(), spain);

    }

    public Country findCountry(String name){
        return countries.get(name);
    }
}
