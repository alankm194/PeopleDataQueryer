package com.alan.peopledataqueryer;

import com.alan.peopledataqueryer.cli.PersonQueryCli;
import com.alan.peopledataqueryer.fileloader.CSVFileLoader;
import com.alan.peopledataqueryer.fileloader.FileLoader;
import com.alan.peopledataqueryer.person.DataQueryer;
import com.alan.peopledataqueryer.person.PersonQueryer;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        FileLoader csvLoader = new CSVFileLoader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter location of file. Accepted Filetypes are CSV.");
        DataQueryer personQueryer = null;
        do {
            String fileLocation = scanner.nextLine();
            try {
                personQueryer = new PersonQueryer(fileLocation, csvLoader);
                PersonQueryCli cli = new PersonQueryCli(personQueryer);
                cli.startApplication();
            } catch (IOException e) {
                System.out.println("Entering enter file location of file to be parsed. Please Try again");
            }
        } while (personQueryer == null);
    }
}

