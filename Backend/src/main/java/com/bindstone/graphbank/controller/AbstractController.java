package com.bindstone.graphbank.controller;

import com.bindstone.graphbank.domain.AbstractNode;
import com.bindstone.graphbank.utils.Header;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractController<T extends AbstractNode> {

    protected ResponseEntity<List<T>> ackEntities(List<T> entities) {
        return (ResponseEntity<List<T>>) new ResponseEntity(entities,
                Header.DEFAULT_LIST(entities),
                HttpStatus.ACCEPTED);
    }

    protected ResponseEntity<T> ackEntity(T entity) {
        return (ResponseEntity<T>) new ResponseEntity(entity,
                Header.DEFAULT_NODE(entity),
                HttpStatus.ACCEPTED);
    }
}
