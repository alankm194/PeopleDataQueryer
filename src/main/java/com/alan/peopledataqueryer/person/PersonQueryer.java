package com.alan.peopledataqueryer.person;

import com.alan.peopledataqueryer.fileloader.FileLoader;
import com.alan.peopledataqueryer.filter.CompanyNameFilterByEsq;
import com.alan.peopledataqueryer.filter.CountyNameFilterByDerbyshire;
import com.alan.peopledataqueryer.filter.PersonFilter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PersonQueryer implements DataQueryer {

    private final List<Person> fullPersonList;

    private final Map<Integer, PersonFilter> optionToFilterMap;
    public PersonQueryer(String fileLocation, FileLoader loader) throws IOException {
        optionToFilterMap = Map.of(
                1, new CompanyNameFilterByEsq(),
                2, new CountyNameFilterByDerbyshire()
        );
        fullPersonList = loader.parseFile(fileLocation);
    }

    public List<Person> executeFilter(int option) {
        PersonFilter personFilter = optionToFilterMap.get(option);
        return personFilter.filter(fullPersonList);
    }


}
