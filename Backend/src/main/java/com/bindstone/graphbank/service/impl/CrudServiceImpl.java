package com.bindstone.graphbank.service.impl;

import com.bindstone.graphbank.domain.DomainObject;
import com.bindstone.graphbank.repository.CrudMapper;
import com.bindstone.graphbank.service.CrudService;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Transactional
public abstract class CrudServiceImpl<T extends DomainObject> implements CrudService<T> {

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getMapper().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(final String id) {
        return (T) getMapper().findById(id);
    }

    @Override
    public T save(final T clazz) {
        if (clazz.getId() == null || clazz.getId().isEmpty()) {
            insert(clazz);
        } else {
            update(clazz);
        }
        return clazz;
    }

    @Override
    public List<T> save(final List<T> clazzes) {
        for (T clazz : clazzes) {
            save(clazz);
        }
        return clazzes;
    }

    @Override
    public T insert(final T clazz) {
        clazz.setCreated(new Timestamp(Calendar.getInstance().getTime().getTime()));
        clazz.setModified(new Timestamp(Calendar.getInstance().getTime().getTime()));
        clazz.setId(UUID.randomUUID().toString());
        getMapper().insert(clazz);
        return clazz;
    }

    @Override
    public T update(final T clazz) {
        clazz.setModified(new Timestamp(Calendar.getInstance().getTime().getTime()));
        getMapper().update(clazz);
        return clazz;
    }

    @Override
    public void delete(final T clazz) {
        getMapper().delete(clazz.getId());
    }

    @Override
    public void delete(final String id) {
        getMapper().delete(id);
    }

    public abstract CrudMapper getMapper();
}
