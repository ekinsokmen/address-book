package com.acme.addressbook.service.impl;

import com.acme.addressbook.data.PersonRepository;
import com.acme.addressbook.exceptions.NoPersonFoundException;
import com.acme.addressbook.model.Person;
import com.acme.addressbook.service.AgeService;

import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class AgeServiceImpl implements AgeService {

    private final PersonRepository personRepository;

    public AgeServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getOldestPerson() {
        Optional<Person> oldestPersonOpt =
                personRepository.getAllPersons().stream().min(Comparator.comparing(Person::getDateOfBirth));
        Person  oldestPerson  =
                oldestPersonOpt.orElseThrow(() -> new NoPersonFoundException("Oldest person not found."));
        return oldestPerson;
    }

    // TODO there is a known issue with duplicate names (like "Bill Foo" and "Bill Doe").
    // TODO Requirements should be clarified to handle duplicate names properly.
    public long getAgeDiffInDaysByName(String nameA, String nameB) {
        Person personA = personRepository.getAllPersons()
                .stream().filter(p -> p.getFullName().contains(nameA)).findFirst()
                .orElseThrow(() -> new NoPersonFoundException("Person A not found."));
        Person personB = personRepository.getAllPersons()
                .stream().filter(p -> p.getFullName().contains(nameB)).findFirst()
                .orElseThrow(() -> new NoPersonFoundException("Person B not found."));
        return calculateDaysBetweenDates(personA.getDateOfBirth(), personB.getDateOfBirth());
    }

    private long calculateDaysBetweenDates(Date d1, Date d2) {
        return TimeUnit.MILLISECONDS.toDays(Math.abs(d1.getTime()-d2.getTime()));
    }

}
