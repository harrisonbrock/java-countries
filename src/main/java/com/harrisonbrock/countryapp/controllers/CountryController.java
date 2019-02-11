package com.harrisonbrock.countryapp.controllers;

import com.harrisonbrock.countryapp.CountryAppApplication;
import com.harrisonbrock.countryapp.domain.Country;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
public class CountryController {

    @RequestMapping("/names/all")
    public List<Country> getAllCountries() {

        CountryAppApplication.countryList.countryList.sort(Comparator.comparing(Country::getName));
        return CountryAppApplication.countryList.countryList;
    }
}
