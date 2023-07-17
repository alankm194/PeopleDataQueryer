package com.alan.peopledataqueryer.person;

import com.alan.peopledataqueryer.fileloader.CSVFileLoader;
import com.alan.peopledataqueryer.fileloader.FileLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonQueryerTest {

    @Test
    public void testCompanyFilterByEsqOption() throws IOException {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("my fake company Esq")
                .address("11 fake street")
                .city("Glasgow")
                .county("fdsfd")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();

        Person testPerson2 = Person.builder().firstName("jj").lastName("doe")
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
        FileLoader mockLoader = mock(CSVFileLoader.class);
        when(mockLoader.parseFile("myfilelocation")).thenReturn(List.of(testPerson, testPerson2));
        PersonQueryer pq = new PersonQueryer("myfilelocation", mockLoader);
        List<Person> results = pq.executeFilter(1);
        assertEquals(1, results.size());
        assertEquals(testPerson, results.get(0));
    }

    @Test
    public void testCountyFilterByDerbyshireOption() throws IOException {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("my fake company Esq")
                .address("11 fake street")
                .city("Glasgow")
                .county("Derbyshire")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();

        Person testPerson2 = Person.builder().firstName("jj").lastName("doe")
                .companyName("my fake company")
                .address("11 fake street")
                .city("Glasgow")
                .county("Lanarkshire")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();
        FileLoader mockLoader = mock(CSVFileLoader.class);
        when(mockLoader.parseFile("myfilelocation")).thenReturn(List.of(testPerson, testPerson2));
        PersonQueryer pq = new PersonQueryer("myfilelocation", mockLoader);
        List<Person> results = pq.executeFilter(2);
        assertEquals(1, results.size());
        assertEquals(testPerson, results.get(0));
    }

    @Test
    public void testAddressHouseNumberisThreeDigitsFilter() throws IOException {
        Person testPerson = Person.builder().firstName("jj").lastName("doe")
                .companyName("my fake company Esq")
                .address("345 fake street")
                .city("Glasgow")
                .county("Derbyshire")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();

        Person testPerson2 = Person.builder().firstName("jj").lastName("doe")
                .companyName("my fake company")
                .address("11 fake street")
                .city("Glasgow")
                .county("Lanarkshire")
                .postal("G4 444")
                .phone1("2345-3333")
                .phone2("2333-1233")
                .email("manny@fakestmail.co.fake")
                .web("https://www.mywebsitetest.test")
                .build();
        FileLoader mockLoader = mock(CSVFileLoader.class);
        when(mockLoader.parseFile("myfilelocation")).thenReturn(List.of(testPerson, testPerson2));
        PersonQueryer pq = new PersonQueryer("myfilelocation", mockLoader);
        List<Person> results = pq.executeFilter(3);
        assertEquals(1, results.size());
        assertEquals(testPerson, results.get(0));
    }
}
