package com.task.crud.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@XmlRootElement
public class Person {


    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;

    private String post;
    private String organization;

    private String mail;
    private List<String> telephoneNumbers;


    @XmlElementWrapper(name = "telephoneNumber")
    @XmlElement(name = "number")
    public List<String> getTelephoneNumbers() {
        return telephoneNumbers;
    }
}
