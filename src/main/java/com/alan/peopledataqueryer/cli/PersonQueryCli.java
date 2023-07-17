package com.alan.peopledataqueryer.cli;

import com.alan.peopledataqueryer.person.DataQueryer;

import java.util.List;
import java.util.Scanner;

public class PersonQueryCli {
    private Scanner scanner;

    private DataQueryer dataQueryer;

    private final List<String> optionsList ;


    public PersonQueryCli(DataQueryer dataQueryer) {
        this.scanner = new Scanner(System.in);
        this.dataQueryer = dataQueryer;
        optionsList = List.of(
                "1: Include only people who have Esq in their company name",
                "2: Include only people who only live in Derbyshire",
                "3: Include only people who have a house number that has 3 digits",
                "4: Include only people who have a website that is larger than 35 characters",
                "5: Include only people who has only 1 digit in the first part of their post code",
                "6: Include only people who has a phone 1 numerically larger than phone 2"
        );
    }

    public void startApplication() {
        boolean exit = false;

        optionsList.forEach(System.out::println);

        do {
            System.out.println();
            System.out.println("Please choose the number corresponding to an available option.");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                exit = true;
            } else {
                try {
                    int option = Integer.parseInt(command);
                    if (option >= 1 && option <= optionsList.size()) {
                        dataQueryer.executeFilter(option).forEach(System.out::println);
                    } else {
                        System.out.println("Error, Number out of range of possible options. Please enter in a number that corresponds to a command");
                    }
                } catch (NumberFormatException E) {
                    System.out.println("Error, command is not a number. Please enter in a number that corresponds with a command.");
                }
            }
        } while (!exit);
    }




}
