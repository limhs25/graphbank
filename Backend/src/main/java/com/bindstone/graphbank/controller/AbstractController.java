package com.bindstone.graphbank.controller;

import com.bindstone.graphbank.domain.AbstractNode;
import com.bindstone.graphbank.utils.rest.Header;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractController<T extends AbstractNode> {

    protected ResponseEntity<Void> ack() {
        return (ResponseEntity<Void>) new ResponseEntity(null,
                Header.defaultHeader(),
                HttpStatus.OK);
    }

    protected ResponseEntity<List<T>> ackEntities(List<T> entities) {
        return (ResponseEntity<List<T>>) new ResponseEntity(entities,
                Header.defaultList(entities),
                HttpStatus.OK);
    }

    protected ResponseEntity<T> ackEntity(T entity) {
        return (ResponseEntity<T>) new ResponseEntity(entity,
                Header.defaultNode(entity),
                HttpStatus.OK);
    }
}
