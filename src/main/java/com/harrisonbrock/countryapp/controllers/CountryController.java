package com.harrisonbrock.countryapp.controllers;

import com.harrisonbrock.countryapp.CountryAppApplication;
import com.harrisonbrock.countryapp.domain.Country;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CountryController {

    @RequestMapping("/names/all")
    public List<Country> getAllCountries() {

        CountryAppApplication.countryList.countryList.sort(Comparator.comparing(Country::getName));
        return CountryAppApplication.countryList.countryList;
    }

    @RequestMapping("/names/begin")
    public List<Country> getCountriesLike(@RequestParam(value = "letters") String letters) {
        CountryAppApplication.countryList.countryList.sort(Comparator.comparing(Country::getName));

        List<Country> newList;
        newList = CountryAppApplication
                .countryList.countryList
                .stream()
                .filter(c -> c.getName().toLowerCase().startsWith(letters.toLowerCase())).collect(Collectors.toList());
        return newList;
    }
}
