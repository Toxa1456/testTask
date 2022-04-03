package com.task.crud.config;


import com.task.crud.model.PersonsList;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class Config {


    public JAXBContext getJAXBContext() throws JAXBException {

        return JAXBContext.newInstance(PersonsList.class);

    }


    @Bean
    public Marshaller getMarshaller() throws JAXBException {

        Marshaller marshaller = getJAXBContext().createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return marshaller;
    }


    @Bean
    public Unmarshaller getUnmarshaller() throws JAXBException {
        return getJAXBContext().createUnmarshaller();
    }
    @Bean
    public File getFile() {
        return new File(".\\src\\main\\resources\\person.xml");
    }
}
