package com.acme.addressbook.view.console.commands;

import com.acme.addressbook.model.Person;
import com.acme.addressbook.service.AgeService;

public class ShowOldestPerson {
    private final AgeService ageService;

    public ShowOldestPerson(AgeService ageService) {
        this.ageService = ageService;
    }

    public void run() {
        Person person = ageService.getOldestPerson();
        System.out.println(String.format("The oldest person is : %s", person));
    }
}
