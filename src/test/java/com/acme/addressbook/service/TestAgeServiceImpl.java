package com.acme.addressbook.service;

import com.acme.addressbook.data.PersonRepository;
import com.acme.addressbook.model.Person;
import com.acme.addressbook.service.impl.AgeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.DateUtil.parse;

public class TestAgeServiceImpl {

    private AgeService ageService;

    @Before
    public void setup() {
        PersonRepository personRepository = mock(PersonRepository.class);
        ageService = new AgeServiceImpl(personRepository);
    }

    @Test
    public void testAgeDiffInDaysByNameSuccess() {
        int days = ageService.getAgeDiffInDaysByName("Bill", "Paul");
        assertThat(days).isEqualTo(2862);
    }

    @Test
    public void testOldestPersonSuccess() {
        Person oldestPerson = ageService.getOldestPerson();
        assertThat(oldestPerson.getFullName()).isEqualTo("Wes Jackson");
        assertThat(oldestPerson.getGender()).isEqualTo(Person.Gender.Male);
        assertThat(oldestPerson.getDateOfBirth()).isEqualTo(parse("1974-08-14"));
    }
}
