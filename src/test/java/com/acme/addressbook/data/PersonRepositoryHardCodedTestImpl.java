package com.acme.addressbook.data;

import com.acme.addressbook.model.Person;
import com.acme.addressbook.model.Person.Gender;

import java.util.*;

public class PersonRepositoryHardCodedTestImpl implements  PersonRepository {

    /*
        Test data based on requirement
        Bill McKnight, Male, 16/03/77
        Paul Robinson, Male, 15/01/85
        Gemma Lane, Female, 20/11/91
        Sarah Stone, Female, 20/09/80
        Wes Jackson, Male, 14/08/74
     */

    private final List<Person> personList;

    public PersonRepositoryHardCodedTestImpl() {
        personList = new ArrayList<Person>();
        personList.add(new Person("Bill McKnight", Gender.Male, toDate(16,3,1977)));
        personList.add(new Person("Paul Robinson", Gender.Male, toDate(15,1,1985)));
        personList.add(new Person("Gemma Lane", Gender.Female, toDate(20,11,1991)));
        personList.add(new Person("Sarah Stone", Gender.Female, toDate(20,9,1980)));
        personList.add(new Person("Wes Jackson", Gender.Male, toDate(14,8,1974)));
    }

    private Date toDate(int day, int month, int year) {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        return calendar.getTime();
    }

    public List<Person> getAllPersons() {
        return personList;
    }
}
