package com.harrisonbrock.countryapp.domain;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private final static AtomicLong counter = new AtomicLong();
    private final long id;
    private final String name;
    private final long population;
    private final long landMss;
    private final int medianAge;

    public Country(String name, long population, long landMss, int medianAge) {

        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMss = landMss;
        this.medianAge = medianAge;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public long getLandMss() {
        return landMss;
    }

    public int getMedianAge() {
        return medianAge;
    }
}
