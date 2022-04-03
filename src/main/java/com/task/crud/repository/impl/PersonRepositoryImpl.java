package com.task.crud.repository.impl;

import com.task.crud.model.PersonsList;
import com.task.crud.repository.PersonRepository;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class PersonRepositoryImpl implements PersonRepository {

    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;
    private final File file;

    public PersonRepositoryImpl(Marshaller marshaller, Unmarshaller unmarshaller, File file) {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
        this.file = file;
    }
    @Override
    public void save(PersonsList clients) throws JAXBException {
        marshaller.marshal(clients, file);
    }

    @Override
    public PersonsList getAllEntity() throws JAXBException {
        return (PersonsList) unmarshaller.unmarshal(file);
    }
}
