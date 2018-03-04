package com.acme.addressbook.model;

import java.util.Date;

public class Person {
    public enum Gender {
        Female,
        Male
    }

    private final String fullName;
    private final Gender gender;
    private final Date dateOfBirth;

    public Person (String fullName, Gender gender, Date dateOfBirth) {
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
