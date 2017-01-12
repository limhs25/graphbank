package com.bindstone.graphbank.service;

import com.bindstone.graphbank.domain.DomainObject;

import java.util.List;

public interface CrudService<T extends DomainObject> {

    List<T> findAll();

    T findById(final String id);

    T insert(final T clazz);

    T update(final T clazz);

    T save(final T clazz);

    List<T> save(final List<T> clazz);

    void delete(T clazz);

    void delete(String id);
}
