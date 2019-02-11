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

    @RequestMapping("/names/size")
    public List<Country> getCountriesLike(@RequestParam(value = "letters") int letters) {
        CountryAppApplication.countryList.countryList.sort(Comparator.comparing(Country::getName));

        List<Country> newList;
        newList = CountryAppApplication
                .countryList.countryList
                .stream()
                .filter(c -> c.getName().length() >= letters).collect(Collectors.toList());
        return newList;
    }

    @RequestMapping("/names/begin")
    public List<Country> getCountriesStartWith(@RequestParam(value = "letter") String letter) {
        CountryAppApplication.countryList.countryList.sort(Comparator.comparing(Country::getName));

        List<Country> newList;
        newList = CountryAppApplication
                .countryList.countryList
                .stream()
                .filter(c -> c.getName().toLowerCase().startsWith(letter.toLowerCase())).collect(Collectors.toList());
        return newList;
    }

    @RequestMapping("/population/size")
    public List<Country> getCountriesWithPopulationGreatThenOrEqualTo(@RequestParam(value = "people") int people) {
        List<Country> newList;
        CountryAppApplication
                .countryList.countryList
                .sort(Comparator.comparing(Country::getPopulation).reversed());
        newList = CountryAppApplication
                .countryList.countryList
                .stream()
                .filter(c -> c.getPopulation() >= people).collect(Collectors.toList());
        return newList;
    }
}
