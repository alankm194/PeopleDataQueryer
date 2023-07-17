package com.alan.peopledataqueryer.fileloader;

import com.alan.peopledataqueryer.person.Person;

import java.io.IOException;
import java.util.List;

public interface FileLoader {

    List<Person> parseFile(String filename) throws IOException;

}
