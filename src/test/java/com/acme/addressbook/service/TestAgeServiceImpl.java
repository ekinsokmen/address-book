package com.acme.addressbook.service;

import com.acme.addressbook.data.PersonRepository;
import com.acme.addressbook.data.PersonRepositoryHardCodedTestImpl;
import com.acme.addressbook.exceptions.NoPersonFoundException;
import com.acme.addressbook.model.Person;
import com.acme.addressbook.service.impl.AgeServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.DateUtil.parse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAgeServiceImpl {

    private AgeService ageServiceWithHardCodedData;
    private AgeService ageServiceWithMockPersonRepository;
    private PersonRepository mockPersonRepository;

    @Before
    public void setup() {
        mockPersonRepository = mock(PersonRepository.class);
        ageServiceWithMockPersonRepository = new AgeServiceImpl(mockPersonRepository);
        PersonRepository personRepository = new PersonRepositoryHardCodedTestImpl();
        ageServiceWithHardCodedData = new AgeServiceImpl(personRepository);
    }

    @Test
    public void testAgeDiffInDaysByNameSuccess() {
        long days = ageServiceWithHardCodedData.getAgeDiffInDaysByName("Bill", "Paul");
        assertThat(days).isEqualTo(2862);
    }

    @Test
    public void testOldestPersonSuccess() {
        Person oldestPerson = ageServiceWithHardCodedData.getOldestPerson();
        assertThat(oldestPerson.getFullName()).isEqualTo("Wes Jackson");
        assertThat(oldestPerson.getGender()).isEqualTo(Person.Gender.Male);
        assertThat(oldestPerson.getDateOfBirth()).isEqualTo(parse("1974-08-14"));
    }

    @Test(expected = NoPersonFoundException.class)
    public void testOldestPersonWithNoPersonFoundException() {
        when(mockPersonRepository.getAllPersons()).thenReturn(new ArrayList<>());
        ageServiceWithMockPersonRepository.getOldestPerson();
    }

    @Test
    public void testAgeDiffInDaysByNameWithNoPersonAFoundException() {
        when(mockPersonRepository.getAllPersons()).thenReturn(new ArrayList<>());
        try {
            ageServiceWithMockPersonRepository.getAgeDiffInDaysByName("Bill", "Paul");
        } catch (NoPersonFoundException ex) {
            assertThat(ex.getMessage()).contains("Person A");
        }
    }

    @Test
    public void testAgeDiffInDaysByNameWithNoPersonBFoundException() {
        when(mockPersonRepository.getAllPersons())
                .thenReturn(Collections.singletonList(
                        new Person("Bill Doo", Person.Gender.Male, parse("1975-08-01"))));
        try {
            ageServiceWithMockPersonRepository.getAgeDiffInDaysByName("Bill", "Paul");
        } catch (NoPersonFoundException ex) {
            assertThat(ex.getMessage()).contains("Person B");
        }
    }

    @Test
    public void testAgeDiffInDaysByNameSuccessWithYearBefore1970() {
        List<Person> testPersons = Arrays.asList(
                new Person("Bill Doo", Person.Gender.Male, parse("1945-01-01")),
                new Person("Paul Doo", Person.Gender.Male, parse("1975-01-01"))
        );
        when(mockPersonRepository.getAllPersons()).thenReturn(testPersons);
        long days = ageServiceWithMockPersonRepository.getAgeDiffInDaysByName("Bill", "Paul");
        assertThat(days).isEqualTo(10957);
    }
}
