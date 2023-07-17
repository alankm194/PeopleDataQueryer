package com.alan.peopledataqueryer.person;

import com.alan.peopledataqueryer.fileloader.FileLoader;
import com.alan.peopledataqueryer.filter.CompanyNameFilterByEsq;
import com.alan.peopledataqueryer.filter.PersonFilter;

import java.io.IOException;
import java.util.List;

public class PersonQueryer implements DataQueryer {

    private final List<Person> fullPersonList;
    public PersonQueryer(String fileLocation, FileLoader loader) throws IOException {
        fullPersonList = loader.parseFile(fileLocation);
    }

    @Override
    public List<Person> filterByCompanyContainsEsq() {
        PersonFilter companyNamefilter = new CompanyNameFilterByEsq();
        return companyNamefilter.filter(fullPersonList);
    }

}
