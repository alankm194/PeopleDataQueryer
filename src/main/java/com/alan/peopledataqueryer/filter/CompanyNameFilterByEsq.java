package com.alan.peopledataqueryer.filter;

import com.alan.peopledataqueryer.Person;

import java.util.List;

public class CompanyNameFilterByEsq implements PersonFilter {

    private final static String SEARCH_TERM = "Esq";

    @Override
    public List<Person> filter(List<Person> people) {
        return people.stream()
                .filter(person -> person.getCompanyName().contains(SEARCH_TERM))
                .toList();
    }
}
