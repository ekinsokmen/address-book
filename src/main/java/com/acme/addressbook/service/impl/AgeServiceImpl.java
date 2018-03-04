package com.acme.addressbook.service.impl;

import com.acme.addressbook.data.PersonRepository;
import com.acme.addressbook.model.Person;
import com.acme.addressbook.service.AgeService;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AgeServiceImpl implements AgeService {

    private final PersonRepository personRepository;

    public AgeServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getOldestPerson() {
        // TODO proper implementation using personRepository
        Calendar calendar = new GregorianCalendar(1974, Calendar.AUGUST, 14);
        return new Person("Wes Jackson", Person.Gender.Male, calendar.getTime());
    }

    public int getAgeDiffInDaysByName(String nameA, String nameB) {
        // TODO proper implementation using personRepository
        return 2862;
    }

}
