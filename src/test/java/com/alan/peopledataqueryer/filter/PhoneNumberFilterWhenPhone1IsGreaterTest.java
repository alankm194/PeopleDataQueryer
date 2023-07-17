package com.alan.peopledataqueryer.filter;

import com.alan.peopledataqueryer.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhoneNumberFilterWhenPhone1IsGreaterTest {
    @Test
    public void whentestListIsEmpty_return0Results() {
        PhoneNumberFilterWhenPhone1isGreater filter = new PhoneNumberFilterWhenPhone1isGreater();
        List<Person> results = filter.filter(Collections.emptyList());
        assertTrue(results.isEmpty());
    }


    @Test
    public void whentestListHasPhone1GreaterPhone2_return1Results() {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("company with Esq")
                .address("11 fake street")
                .city("Glasgow")
                .county("Derbyshire")
                .postal("G4 444")
                .phone1("8888-3333")
                .phone2("2334-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();
        PhoneNumberFilterWhenPhone1isGreater filter = new PhoneNumberFilterWhenPhone1isGreater();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(1, results.size());
        assertEquals(testPerson, results.get(0));
    }


    @Test
    public void whenTestListHasPhone2GreaterThanPhone1_return0Result() {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("my fake company")
                .address("11 fake street")
                .city("Glasgow")
                .county("fdsfd")
                .postal("G45 444")
                .phone1("2345-3333")
                .phone2("8787-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();
        PhoneNumberFilterWhenPhone1isGreater filter = new PhoneNumberFilterWhenPhone1isGreater();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(0, results.size());
    }

    @Test
    public void whenTestContains4postcodewithSingleDigit_return4Results() {
        List<Person> testList = new ArrayList<>();
        Map<String, String> phone1GreaterMap = Map.of(
                "09916-963261", "01370-319414",
                "03552-682601",	"01953-816728",
                "01993-754681",	"01972-686199",
                "01441-846477",	"01332-799979"
        );
        Map<String, String> phone1LessThanMap = Map.of(
                "01916-963261", "02446-936944",
                "01552-682601", "01721-747819",
                "01093-754681", "01606-833878",
                "03441-846477", "05478-392232"
        );
        phone1GreaterMap.forEach((key, value) -> {
            Person mockPersonPhone1Larger = mock(Person.class);
            when(mockPersonPhone1Larger.getPhone1()).thenReturn(key);
            when(mockPersonPhone1Larger.getPhone2()).thenReturn(value);
            testList.add(mockPersonPhone1Larger);
        });

        phone1LessThanMap.forEach((key, value) -> {
            Person mockPersonPhone2Larger = mock(Person.class);
            when(mockPersonPhone2Larger.getPhone1()).thenReturn(key);
            when(mockPersonPhone2Larger.getPhone2()).thenReturn(value);
            testList.add(mockPersonPhone2Larger);
        });

        PhoneNumberFilterWhenPhone1isGreater filter = new PhoneNumberFilterWhenPhone1isGreater();
        List<Person> results = filter.filter(testList);
        assertEquals(4, results.size());

        results.forEach(result -> assertTrue(phone1GreaterMap.containsKey(result.getPhone1())));
        results.forEach(result -> assertFalse(phone1LessThanMap.containsKey(result.getPhone1())));
    }
}
