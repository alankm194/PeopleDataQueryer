package com.alan.peopledataqueryer.filter;

import com.alan.peopledataqueryer.person.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressFilterByThreeDigitsTest {

    @Test
    public void whentestListIsEmpty_return0Results() {
        AddressFilterByThreeDigitHousenumber filter = new AddressFilterByThreeDigitHousenumber();
        List<Person> results = filter.filter(Collections.emptyList());
        assertTrue(results.isEmpty());
    }

    @Test
    public void whentestListHas1HouseNumberWith3Digits_return1Results() {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("company with Esq")
                .address("231 fake street")
                .city("Glasgow")
                .county("Derbyshire")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();
        AddressFilterByThreeDigitHousenumber filter = new AddressFilterByThreeDigitHousenumber();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(1, results.size());
        assertEquals(testPerson, results.get(0));
    }

    @Test
    public void whenTestListhasNoHouseNumberWith3Digits_return0Result() {
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
        AddressFilterByThreeDigitHousenumber filter = new AddressFilterByThreeDigitHousenumber();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(0, results.size());
    }

    @Test
    public void whenTestContains4HouseWith3Digits_return4Results() {
        List<Person> testList = new ArrayList<>();
        var houseDigitList = List.of("100", "101", "334", "999");
        for (int i = 0; i < 4; i++) {
            Person mockPersonWith3Digits = mock(Person.class);
            when(mockPersonWith3Digits.getAddress()).thenReturn(houseDigitList.get(i) + " main street");
            testList.add(mockPersonWith3Digits);
        }
        for (int i = 0; i < 6; i++) {
            Person mockPersonWithSingleDigit = mock(Person.class);
            when(mockPersonWithSingleDigit.getAddress()).thenReturn(i + " good road");
            testList.add(mockPersonWithSingleDigit);
        }
        AddressFilterByThreeDigitHousenumber filter = new AddressFilterByThreeDigitHousenumber();
        List<Person> results = filter.filter(testList);
        assertEquals(4, results.size());
        for (int i = 0; i < 4; i++) {
            assertTrue(results.get(i).getAddress().contains(houseDigitList.get(i)));
        }
    }
}
