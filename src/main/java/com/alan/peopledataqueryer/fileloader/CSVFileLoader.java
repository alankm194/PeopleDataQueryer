package com.alan.peopledataqueryer.fileloader;

import com.alan.peopledataqueryer.person.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileLoader implements FileLoader{

    private static final int STARTING_POSITION = 2;
    enum CSVHeaders {
        first_name,
        last_name,
        company_name,
        address,
        city,
        county,
        postal,
        phone1,
        phone2,
        email,
        web;
    }

    private final CSVFormat format;
    public CSVFileLoader() {
        format = CSVFormat.Builder
                .create()
                .setHeader(CSVHeaders.class)
                .setSkipHeaderRecord(true)
                .build();
    }

    public List<Person> parseFile(String fileLocation) throws IOException {
        Reader in = new FileReader(fileLocation);
        Iterable<CSVRecord> records = format.parse(in);
        List<Person> peopleList = new ArrayList<>();
        int position = STARTING_POSITION;
        for (CSVRecord csvRecord : records) {
            Person person = Person.builder()
                    .position(String.valueOf(position))
                    .firstName(csvRecord.get(CSVHeaders.first_name))
                    .lastName(csvRecord.get(CSVHeaders.last_name))
                    .companyName(csvRecord.get(CSVHeaders.company_name))
                    .address(csvRecord.get(CSVHeaders.address))
                    .city(csvRecord.get(CSVHeaders.city))
                    .county(csvRecord.get(CSVHeaders.county))
                    .postal(csvRecord.get(CSVHeaders.postal))
                    .phone1(csvRecord.get(CSVHeaders.phone1))
                    .phone2(csvRecord.get(CSVHeaders.phone2))
                    .email(csvRecord.get(CSVHeaders.email))
                    .web(csvRecord.get(CSVHeaders.web))
                    .build();
            peopleList.add(person);
            position++;
        }
        return peopleList;
    }

}
