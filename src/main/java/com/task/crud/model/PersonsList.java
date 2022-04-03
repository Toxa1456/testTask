package com.task.crud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@Data
@AllArgsConstructor @NoArgsConstructor
@XmlRootElement
public class PersonsList {

    private List<Person> persons;

    @XmlElementWrapper(name = "persons")
    @XmlElement(name = "person")
    public List<Person> getPersons() {
        return persons;
    }
}
