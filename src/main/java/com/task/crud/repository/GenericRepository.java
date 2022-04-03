package com.task.crud.repository;

import javax.xml.bind.JAXBException;

public interface GenericRepository<T> {

    void save(T entity) throws JAXBException;

    T getAllEntity() throws JAXBException;


}
