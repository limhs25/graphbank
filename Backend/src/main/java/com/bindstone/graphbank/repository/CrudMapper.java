package com.bindstone.graphbank.repository;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * General Interface used common operations:
 * Create, Read, Update, Delete
 *
 * @param <T> Generic Domain Object
 */
public interface CrudMapper<T> {

    List<T> findAll();

    T findById(final @Param("id") String id);

    void insert(final T clazz);

    void update(final T clazz);

    void delete(final @Param("id") String id);

}
