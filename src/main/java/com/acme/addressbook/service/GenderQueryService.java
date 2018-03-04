package com.acme.addressbook.service;

import com.acme.addressbook.model.Person;

public interface GenderQueryService {
    long countByGender(Person.Gender gender);
}
