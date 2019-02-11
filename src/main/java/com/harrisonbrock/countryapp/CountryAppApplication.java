package com.harrisonbrock.countryapp;

import com.harrisonbrock.countryapp.data.CountryList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryAppApplication {

    public static CountryList countryList;
    public static void main(String[] args) {

        countryList = new CountryList();
        SpringApplication.run(CountryAppApplication.class, args);
    }

}

