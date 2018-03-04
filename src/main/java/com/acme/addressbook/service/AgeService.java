package com.acme.addressbook.service;

import com.acme.addressbook.model.Person;

public interface AgeService {
    Person getOldestPerson();
    long getAgeDiffInDaysByName(String nameA, String nameB);
}
