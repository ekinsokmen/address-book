package com.acme.addressbook.data;

import com.acme.addressbook.model.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> getAllPersons();
}
