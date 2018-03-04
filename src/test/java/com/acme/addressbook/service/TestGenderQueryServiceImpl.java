package com.acme.addressbook.service;

import com.acme.addressbook.data.PersonRepository;
import com.acme.addressbook.data.PersonRepositoryHardCodedTestImpl;
import com.acme.addressbook.model.Person;
import com.acme.addressbook.service.impl.GenderQueryServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestGenderQueryServiceImpl {

    private GenderQueryService genderQueryService;

    @Before
    public void setup() {
        PersonRepository personRepository = new PersonRepositoryHardCodedTestImpl();
        genderQueryService = new GenderQueryServiceImpl(personRepository);
    }

    @Test
    public void testCountMales() {
        long numberOfMalePersons = genderQueryService.countByGender(Person.Gender.Male);
        assertThat(numberOfMalePersons).isEqualTo(3);
    }
}
