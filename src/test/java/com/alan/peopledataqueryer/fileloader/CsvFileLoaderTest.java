package com.alan.peopledataqueryer.fileloader;

import com.alan.peopledataqueryer.person.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvFileLoaderTest {


    private static List<Person> listPeople;
    @BeforeAll
    public static void loadCsvFile() throws IOException {
        CSVFileLoader csvLoader = new CSVFileLoader();
        listPeople = csvLoader.parseFile("src/test/resources/test.csv");
    }

    @Test
    public void whenCSVHas3Records_thenListHasSize3() {
        assertEquals(3, listPeople.size());
    }

    @Test
    public void TestCsvRecord_hasCorrectFirstRecord() {
        Person testPerson = listPeople.get(0);
        Person expectedPerson = Person.builder()
                .firstName("Aleshia")
                .lastName("Tomkiewicz")
                .companyName("Alan D Rosenburg Cpa Pc")
                .address("14 Taylor St")
                .city("St. Stephens Ward")
                .county("Kent")
                .postal("CT2 7PP")
                .phone1("01835-703597")
                .phone2("01944-369967")
                .email("atomkiewicz@hotmail.com")
                .web("http://www.alandrosenburgcpapc.co.uk")
                .position("2")
                .build();
        assertEquals(expectedPerson, testPerson);
    }

    @Test
    public void TestCsvRecord_hasCorrectSecondRecord() {
        Person testPerson = listPeople.get(1);
        Person expectedPerson = Person.builder()
                .firstName("Evan")
                .lastName("Zigomalas")
                .companyName("Cap Gemini America")
                .address("5 Binney St")
                .city("Abbey Ward")
                .county("Buckinghamshire")
                .postal("HP11 2AX")
                .phone1("01937-864715")
                .phone2("01714-737668")
                .email("evan.zigomalas@gmail.com")
                .web("http://www.capgeminiamerica.co.uk")
                .position("3")
                .build();
        assertEquals(expectedPerson, testPerson);
    }

    @Test
    public void TestCsvRecord_hasCorrectThirdRecord() {
        Person testPerson = listPeople.get(2);
        Person expectedPerson = Person.builder()
                .firstName("France")
                .lastName("Andrade")
                .companyName("Elliott, John W Esq")
                .address("8 Moor Place")
                .city("East Southbourne and Tuckton W")
                .county("Bournemouth")
                .postal("BH6 3BE")
                .phone1("01347-368222")
                .phone2("01935-821636")
                .email("france.andrade@hotmail.com")
                .web("http://www.elliottjohnwesq.co.uk")
                .position("4")
                .build();
        assertEquals(expectedPerson, testPerson);
    }
}
