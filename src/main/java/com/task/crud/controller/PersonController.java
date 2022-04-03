package com.task.crud.controller;


import com.task.crud.model.Person;
import com.task.crud.service.PersonService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService personService) {
        this.service = personService;
    }


    public List<Person> showAll(){
        return service.getAllPersons();
    }

    public String add(Person person) {
        return service.addPerson(person);
    }

    public String change(Person person) {
        return service.updatePerson(person);
    }

    public String delete(Long id) {
        return service.deleteById(id);
    }

    public Person find(Long id) {
        return service.getById(id);
    }

}
