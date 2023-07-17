package com.alan.peopledataqueryer.filter;

import com.alan.peopledataqueryer.Person;

import java.util.List;

public class CountyNameFilterByDerbyshire implements PersonFilter {
    private static final String COUNTY_SEARCH_TERM = "Derbyshire";

    @Override
    public List<Person> filter(List<Person> people) {
        return people.stream()
                .filter(person -> person.getCounty().equalsIgnoreCase(COUNTY_SEARCH_TERM))
                .toList();
    }
}
