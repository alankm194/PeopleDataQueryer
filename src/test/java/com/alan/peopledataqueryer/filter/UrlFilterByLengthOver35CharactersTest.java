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

public class UrlFilterByLengthOver35CharactersTest {


    @Test
    public void whentestListIsEmpty_return0Results() {
        UrlFilterByLengthOver35Characters filter = new UrlFilterByLengthOver35Characters();
        List<Person> results = filter.filter(Collections.emptyList());
        assertTrue(results.isEmpty());
    }

    @Test
    public void whentestListUrlover35Chars_return1Results() {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("company with Esq")
                .address("231 fake street")
                .city("Glasgow")
                .county("Derbyshire")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.verylargewebsitenametest.test")
                .build();
        UrlFilterByLengthOver35Characters filter = new UrlFilterByLengthOver35Characters();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(1, results.size());
        assertEquals(testPerson, results.get(0));
    }

    @Test
    public void whenTestListhasUrlUnder35Chars_return0Result() {
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
        UrlFilterByLengthOver35Characters filter = new UrlFilterByLengthOver35Characters();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(0, results.size());
    }

    @Test
    public void whenTestListHasUrlOver35CharsButNoProtocol_return1Result() {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("my fake company")
                .address("11 fake street")
                .city("Glasgow")
                .county("fdsfd")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("www.megaverylargewebsiteverybigmassiveHuge.co.uk")
                .build();
        UrlFilterByLengthOver35Characters filter = new UrlFilterByLengthOver35Characters();
        List<Person> results = filter.filter(List.of(testPerson));
        assertEquals(1, results.size());
        assertEquals(testPerson, results.get(0));
    }

    @Test
    public void whenTestContains4UrlsOver35Chars_return4Results() {
        List<Person> testList = new ArrayList<>();
        var UrlList = List.of("https://www.HugeLargeMassiveWebsiteNaming.site",
                "https://www.megaverylargewebsite.co.uk",
                "https://www.mywebsitethathasverylongname.com",
                "https://www.websitethatisfartoolongbutstillused.com");
        for (int i = 0; i < 4; i++) {
            Person mockPersonUrlOver35Chars = mock(Person.class);
            when(mockPersonUrlOver35Chars.getWeb()).thenReturn(UrlList.get(i));
            testList.add(mockPersonUrlOver35Chars);
        }
        for (int i = 0; i < 6; i++) {
            Person mockPersonUrlunder35Chars = mock(Person.class);
            when(mockPersonUrlunder35Chars.getWeb()).thenReturn(String.format("http://www.mysite%d.com", i));
            testList.add(mockPersonUrlunder35Chars);
        }
        UrlFilterByLengthOver35Characters filter = new UrlFilterByLengthOver35Characters();
        List<Person> results = filter.filter(testList);
        assertEquals(4, results.size());
        for (int i = 0; i < 4; i++) {
            assertEquals(results.get(i).getWeb(), UrlList.get(i));
        }
    }
}
