package com.alan.peopledataqueryer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String position;
    private String firstName;
    private String lastName;
    private String companyName;
    private String address;
    private String city;
    private String county;
    private String postal;
    private String phone1;
    private String phone2;
    private String email;
    private String web;
}
