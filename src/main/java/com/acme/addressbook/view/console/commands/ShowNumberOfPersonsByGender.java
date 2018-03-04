package com.acme.addressbook.view.console.commands;

import com.acme.addressbook.model.Person;
import com.acme.addressbook.service.GenderQueryService;

public class ShowNumberOfPersonsByGender {

    private final GenderQueryService genderQueryService;

    public ShowNumberOfPersonsByGender(GenderQueryService genderQueryService) {
        this.genderQueryService = genderQueryService;
    }

    public void run (String[] args) {
        Person.Gender gender = Person.Gender.valueOf(args[2]);
        long count = genderQueryService.countByGender(gender);
        System.out.println(String.format("There are [%d] person of gender [%s].", count, gender));
    }
}
