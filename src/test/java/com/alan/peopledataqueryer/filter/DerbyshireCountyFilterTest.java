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

public class DerbyshireCountyFilterTest {


    @Test
    public void whenTestListIsEmpty_returnEmptyList() {
        CountyNameFilterByDerbyshire filter = new CountyNameFilterByDerbyshire();
        List<Person> results = filter.filter(Collections.emptyList());
        assertTrue(results.isEmpty());
    }

    @Test
    public void whenTestListContains1Derbyshire_return1Result() {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("company")
                .address("11 fake street")
                .city("Derby")
                .county("Derbyshire")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();
        CountyNameFilterByDerbyshire filter = new CountyNameFilterByDerbyshire();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(1, results.size());
        assertEquals(testPerson, results.get(0));
    }

    @Test
    public void whenTestListContains0Derbyshire_return0Result() {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("company")
                .address("11 fake street")
                .city("Glasgow")
                .county("fdsfd")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();
        CountyNameFilterByDerbyshire filter = new CountyNameFilterByDerbyshire();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(0, results.size());
    }


    @Test
    public void whenTestContainsMixtureOfDerbyshire_return4Results() {
        List<Person> testList = new ArrayList<>();
        String derbyshire = "Derbyshire";
        for (int i = 0; i < 4; i++) {
            Person mockPersonFromDerbyshire = mock(Person.class);
            when(mockPersonFromDerbyshire.getCounty()).thenReturn(derbyshire);
            testList.add(mockPersonFromDerbyshire);
        }
        for (int i = 0; i < 6; i++) {
            Person mockPersonNotDerbyshire = mock(Person.class);
            when(mockPersonNotDerbyshire.getCounty()).thenReturn("Clackmannashire" + i);
            testList.add(mockPersonNotDerbyshire);
        }
        CountyNameFilterByDerbyshire filter = new CountyNameFilterByDerbyshire();
        List<Person> results = filter.filter(testList);
        assertEquals(4, results.size());
        results.forEach(result -> assertEquals(derbyshire, result.getCounty()));
    }

}
