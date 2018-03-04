package com.acme.addressbook.data;

import com.acme.addressbook.data.impl.PersonRepositoryFileImporterImpl;
import com.acme.addressbook.model.Person;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.DateUtil.parse;

public class TestPersonRepositoryFileImporterImpl {


    @Test
    public void loadDefaultFile () {
        PersonRepositoryFileImporterImpl personRepository =
                new PersonRepositoryFileImporterImpl("AddressBook");
        List<Person> personList = personRepository.getAllPersons();
        assertThat(personList.size()).isEqualTo(5);
        // assert Sarah Stone, Female, 20/09/80
        Optional<Person> somePerson =
                personList.stream().filter(p -> p.getFullName().equals("Sarah Stone")).findFirst();
        assertThat(somePerson).isNotEmpty();
        Person person = somePerson.get();
        assertThat(person.getFullName()).isEqualTo("Sarah Stone");
        assertThat(person.getGender()).isEqualTo(Person.Gender.Female);
        assertThat(person.getDateOfBirth()).isEqualTo(parse("1980-09-20"));
    }
}
