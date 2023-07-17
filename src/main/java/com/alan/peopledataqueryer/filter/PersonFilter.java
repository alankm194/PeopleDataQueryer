package com.alan.peopledataqueryer.filter;

import com.alan.peopledataqueryer.person.Person;

import java.util.List;

public interface PersonFilter {

    public List<Person> filter(List<Person> people);

}
