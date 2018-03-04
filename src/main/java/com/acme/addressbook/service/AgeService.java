package com.acme.addressbook.service;

import com.acme.addressbook.model.Person;

public interface AgeService {
    Person getOldestPerson();
    int getAgeDiffInDaysByName(String nameA, String nameB);
}
