package com.task.crud.service;

import com.task.crud.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonService {

    Person getById(Long id);

    List<Person> getAllPersons();

    String deleteById(Long id);

    String addPerson(Person person);

    String updatePerson(Person person);



}
