package com.acme.addressbook.view.console.commands;

import com.acme.addressbook.service.AgeService;

public class ShowAgeDiffInDays {

    private final AgeService ageService;

    public ShowAgeDiffInDays(AgeService ageService) {
        this.ageService = ageService;
    }

    public void run (String[] args) {
        String nameA = args[2];
        String nameB = args[3];
        long days = ageService.getAgeDiffInDaysByName(nameA, nameB);
        System.out.println(String.format("%s and %s have %s days between their birth dates.", nameA, nameB, days));
    }
}
