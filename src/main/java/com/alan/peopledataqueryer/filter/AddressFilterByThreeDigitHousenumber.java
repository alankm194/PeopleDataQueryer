package com.alan.peopledataqueryer.filter;

import com.alan.peopledataqueryer.person.Person;

import java.util.List;

public class AddressFilterByThreeDigitHousenumber implements PersonFilter {
    @Override
    public List<Person> filter(List<Person> people) {
        return people.stream()
                .filter(person -> isThreeDigitHouseNumber(person.getAddress()))
                .toList();
    }

    private boolean isThreeDigitHouseNumber(String address) {
        int houseNumEndIndex = address.indexOf(" ");
        if (houseNumEndIndex == -1) return false;

        String houseNumber = address.substring(0, houseNumEndIndex);
        if (houseNumber.length() == 3)  {
            try {
                Integer.parseInt(houseNumber);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
