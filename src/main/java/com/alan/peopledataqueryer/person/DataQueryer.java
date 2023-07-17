package com.alan.peopledataqueryer.person;


import java.util.List;

public interface DataQueryer {

    public List<Person> filterByCompanyContainsEsq();

    public List<Person> filterByCountyNameDerbyshire();
}
