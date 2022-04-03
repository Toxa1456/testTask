package com.task.crud.service.impl;


import com.task.crud.model.PersonsList;
import com.task.crud.model.Person;
import com.task.crud.repository.PersonRepository;
import com.task.crud.service.PersonService;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    private final String error = "error";
    private final String ok = "ok";
    private final String not_found = "not_found";

    public PersonServiceImpl(PersonRepository clientRepository) {
        this.repository = clientRepository;
    }

    @Override
    public Person getById(Long id) {
        List<Person> list = getPersons();
        Person person;
        if (list == null) {
            return null;
        }
        Optional<Person> optPerson = list.stream().filter(per -> per.getId().equals(id)).findAny();
        if (optPerson.isPresent()) {
            person = optPerson.get();
        } else {
            return null;
        }
        return person;
    }

    @Override
    public List<Person> getAllPersons() {
        return getPersons();
    }

    @Override
    public String deleteById(Long id) {
        List<Person> list = getPersons();
        if (list == null) {
            return error;
        }
        list.removeIf(per -> per.getId().equals(id));
        try {
            repository.save(new PersonsList(list));
        } catch (JAXBException exception) {
            return error;
        }
        return ok;
    }

    @Override
    public String addPerson(Person person) {
        List<Person> list = getPersons();
        if (list == null) {
            list = new ArrayList<>();
            person.setId(1L);
        } else {
            person.setId((long) list.size() + 1);
        }
        list.add(person);
        try {
            repository.save(new PersonsList(list));
        } catch (JAXBException exception) {
            return error;
        }
        return ok;
    }

    @Override
    public String updatePerson(Person person) {
        List<Person> list = getPersons();
        if (list == null) {
            return error;
        }
        list.removeIf(per -> per.getId().equals(person.getId()));
        list.add(person);
        try {
            repository.save(new PersonsList(list));
        } catch (JAXBException exception) {
            return error;
        }
        return ok;
    }

    private List<Person> getPersons()  {
        try {
            return repository.getAllEntity().getPersons();
        } catch (JAXBException ignored) {
        }
        return null;
    }

}
