package com.alan.peopledataqueryer.person;

import com.alan.peopledataqueryer.fileloader.FileLoader;
import com.alan.peopledataqueryer.filter.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PersonQueryer implements DataQueryer {

    private final List<Person> fullPersonList;

    private final Map<Integer, PersonFilter> optionToFilterMap;
    public PersonQueryer(String fileLocation, FileLoader loader) throws IOException {
        optionToFilterMap = Map.of(
                1, new CompanyNameFilterByEsq(),
                2, new CountyNameFilterByDerbyshire(),
                3, new AddressFilterByThreeDigitHousenumber(),
                4, new UrlFilterByLengthOver35Characters(),
                5, new PostCodeFilterBySingleDigit(),
                6, new PhoneNumberFilterWhenPhone1isGreater()
        );
        fullPersonList = loader.parseFile(fileLocation);
    }

    public List<Person> executeFilter(int option) {
        PersonFilter personFilter = optionToFilterMap.get(option);
        return personFilter.filter(fullPersonList);
    }


}
