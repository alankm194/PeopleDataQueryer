package com.alan.peopledataqueryer.filter;

import com.alan.peopledataqueryer.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompanyNameFilterByEsqTest {

    @Test
    public void whentestListIsEmpty_return0Results() {
        CompanyNameFilterByEsq filter = new CompanyNameFilterByEsq();
        List<Person> results = filter.filter(Collections.emptyList());
        assertTrue(results.isEmpty());
    }


    @Test
    public void whentestListHas1EsqCompany_return1Results() {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("company with Esq")
                .address("11 fake street")
                .city("Glasgow")
                .county("Derbyshire")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();
        CompanyNameFilterByEsq filter = new CompanyNameFilterByEsq();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(1, results.size());
        assertEquals(testPerson, results.get(0));
    }


    @Test
    public void whenTestListContains0EsqCompany_return0Result() {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("my fake company")
                .address("11 fake street")
                .city("Glasgow")
                .county("fdsfd")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();
        CompanyNameFilterByEsq filter = new CompanyNameFilterByEsq();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(0, results.size());
    }

    @Test
    public void whenTestContains4CompaniesWithEsq_return4Results() {
        List<Person> testList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Person mockPersonCompanyNameWithEsq = mock(Person.class);
            when(mockPersonCompanyNameWithEsq.getCompanyName()).thenReturn("company with Esq " + i);
            testList.add(mockPersonCompanyNameWithEsq);
        }
        for (int i = 0; i < 6; i++) {
            Person mockPersonCompanyNameWithoutEsq = mock(Person.class);
            when(mockPersonCompanyNameWithoutEsq.getCompanyName()).thenReturn("my company " + i);
            testList.add(mockPersonCompanyNameWithoutEsq);
        }
        CompanyNameFilterByEsq filter = new CompanyNameFilterByEsq();
        List<Person> results = filter.filter(testList);
        assertEquals(4, results.size());
        results.forEach(result -> assertTrue(result.getCompanyName().contains("Esq")));
    }


}
