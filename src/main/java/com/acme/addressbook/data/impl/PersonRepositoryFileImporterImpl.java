package com.acme.addressbook.data.impl;

import com.acme.addressbook.data.PersonRepository;
import com.acme.addressbook.exceptions.AddressBookNotValid;
import com.acme.addressbook.model.Person;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PersonRepositoryFileImporterImpl implements PersonRepository {

    private final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yy");
    private final List<Person> personList;

    public PersonRepositoryFileImporterImpl(String fileName) {
        this(new File(fileName));
    }

    public PersonRepositoryFileImporterImpl(File file) {
        try {
            List<String> lines = FileUtils.readLines(file, Charset.defaultCharset());
            personList = lines.stream().map(this::lineToPerson).collect(Collectors.toList());
        } catch (IOException ex) {
            throw new AddressBookNotValid(String.format("Error reading file [%s].", file), ex);
        }
    }

    private Person lineToPerson(String line) {
        String[] parts = StringUtils.split(line, ',');
        if (parts.length < 3) {
            throw new AddressBookNotValid(String.format("Missing part on line [%s].", line));
        }
        Person person = new Person(
                StringUtils.trim(parts[0]),
                toGender(StringUtils.trim(parts[1])),
                toDate(StringUtils.trim(parts[2])));
        return person;
    }

    private Person.Gender toGender(String genderStr) {
        try {
            return Person.Gender.valueOf(StringUtils.trim(genderStr));
        } catch (Exception ex) {
            throw new AddressBookNotValid(String.format("Gender string not valid [%s].", genderStr), ex);
        }
    }

    private Date toDate(String dateStr) {
        try {
            return DATE_FORMATTER.parse(dateStr);
        } catch (Exception ex) {
            throw new AddressBookNotValid(String.format("Date of birth string not valid [%s].", dateStr), ex);
        }
    }

    @Override
    public List<Person> getAllPersons() {
        return personList;
    }

}
