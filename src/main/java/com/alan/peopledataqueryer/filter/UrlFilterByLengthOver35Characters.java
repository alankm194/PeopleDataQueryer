package com.alan.peopledataqueryer.filter;

import com.alan.peopledataqueryer.person.Person;

import java.util.List;

public class UrlFilterByLengthOver35Characters implements PersonFilter {

    private static final int URL_LENGTH_FILTER = 35;
    @Override
    public List<Person> filter(List<Person> people) {
        return people.stream()
                .filter(person -> person.getWeb().length() > URL_LENGTH_FILTER)
                .toList();
    }
}
