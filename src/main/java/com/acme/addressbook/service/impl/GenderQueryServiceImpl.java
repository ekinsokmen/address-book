package com.acme.addressbook.service.impl;

import com.acme.addressbook.data.PersonRepository;
import com.acme.addressbook.model.Person;
import com.acme.addressbook.service.GenderQueryService;

public class GenderQueryServiceImpl implements GenderQueryService {

    private final PersonRepository personRepository;

    public GenderQueryServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public long countByGender(Person.Gender gender) {
        return personRepository.getAllPersons().stream().filter(p -> p.getGender().equals(gender)).count();
    }

}
