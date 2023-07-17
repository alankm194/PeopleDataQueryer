package com.alan.peopledataqueryer.filter;

import com.alan.peopledataqueryer.Person;

import java.util.List;
import java.util.Optional;

public class PhoneNumberFilterWhenPhone1isGreater implements PersonFilter {
    @Override
    public List<Person> filter(List<Person> people) {
        return people.stream()
                .filter(person -> isPhone1BiggerThanPhone2(person.getPhone1(), person.getPhone2()))
                .toList();
    }
    private boolean isPhone1BiggerThanPhone2(String phone1, String phone2) {
        //defaults values are set to min value and max value, This ensures that if any phone number is missing it defaults to false
        var integerPhone1 = convertPhoneToLong(phone1).orElse(Long.MIN_VALUE);
        var integerPhone2 = convertPhoneToLong(phone2).orElse(Long.MAX_VALUE);

        return integerPhone1 > integerPhone2;
    }

    private Optional<Long> convertPhoneToLong(String phone) {
        if (phone.contains("-")) {
            phone = phone.replace("-", "");
        }
        try {
            return Optional.of(Long.parseLong(phone));
        } catch (NumberFormatException E) {
            return Optional.empty();
        }
    }
}
