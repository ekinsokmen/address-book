package com.acme.addressbook.view.console;

import com.acme.addressbook.data.PersonRepository;
import com.acme.addressbook.data.impl.PersonRepositoryFileImporterImpl;
import com.acme.addressbook.service.AgeService;
import com.acme.addressbook.service.GenderQueryService;
import com.acme.addressbook.service.impl.AgeServiceImpl;
import com.acme.addressbook.service.impl.GenderQueryServiceImpl;
import com.acme.addressbook.view.console.commands.ShowAgeDiffInDays;
import com.acme.addressbook.view.console.commands.ShowNumberOfPersonsByGender;
import com.acme.addressbook.view.console.commands.ShowOldestPerson;

public class CommandLineApp {

    public enum Command {
        ShowNumberOfPersonsByGender,
        ShowOldestPerson,
        ShowAgeDiffInDays
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            printHelp();
            System.exit(1);
        }
        PersonRepository personRepository = new PersonRepositoryFileImporterImpl(args[0]);
        AgeService ageService = new AgeServiceImpl(personRepository);
        GenderQueryService genderQueryService = new GenderQueryServiceImpl(personRepository);
        Command command = Command.valueOf(args[1]);
        System.out.println("==================");
        System.out.println();
        switch (command) {
            case ShowNumberOfPersonsByGender:
                runShowNumberOfPersonsByGender(args, genderQueryService);
                break;
            case ShowOldestPerson:
                runShowOldestPerson(args, ageService);
                break;
            case ShowAgeDiffInDays:
                runShowAgeDiffInDays(args, ageService);
        }
        System.out.println();
        System.out.println("==================");
    }

    private static void runShowAgeDiffInDays(String[] args, AgeService ageService) {
        ShowAgeDiffInDays showAgeDiffInDays = new ShowAgeDiffInDays(ageService);
        showAgeDiffInDays.run(args);
    }

    private static void runShowOldestPerson(String[] args, AgeService ageService) {
        ShowOldestPerson showOldestPerson = new ShowOldestPerson(ageService);
        showOldestPerson.run();
    }

    private static void runShowNumberOfPersonsByGender(String[] args, GenderQueryService genderQueryService) {
        ShowNumberOfPersonsByGender showNumberOfPersonsByGender = new ShowNumberOfPersonsByGender(genderQueryService);
        showNumberOfPersonsByGender.run(args);
    }

    private static void printHelp() {
        System.out.println("Sample usage:");
        System.out.println("CommandLineApp <fileName> <command> <param>");
        System.out.println("------");
        System.out.println("Available commands:");
        System.out.println("... ShowNumberOfPersonsByGender {Male,Female}");
        System.out.println("... ShowOldestPerson");
        System.out.println("... ShowAgeDiffInDays <nameA> <nameB>");
    }

}
