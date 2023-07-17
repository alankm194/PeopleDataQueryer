package com.alan.peopledataqueryer.filter;

import com.alan.peopledataqueryer.person.Person;

import java.util.List;

public class PostCodeFilterBySingleDigit implements PersonFilter {
    @Override
    public List<Person> filter(List<Person> people) {
        return people.stream()
                .filter(person -> hasSingleDigitPostCode(person.getPostal()))
                .toList();
    }

    private boolean hasSingleDigitPostCode(String postCode) {
        int firstPartPostcodeIndex = postCode.indexOf(" ");
        if (firstPartPostcodeIndex == -1) return false;

        String firstPartPostCode = postCode.substring(0, firstPartPostcodeIndex);
        int integerCount = 0;
        for (char character: firstPartPostCode.toCharArray()) {
            if (Character.isDigit(character)) {
                integerCount += 1;
            }
        }

        return integerCount == 1;
    }
}
