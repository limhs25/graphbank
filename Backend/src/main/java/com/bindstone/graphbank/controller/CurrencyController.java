package com.bindstone.graphbank.controller;


import com.bindstone.graphbank.domain.Currency;
import com.bindstone.graphbank.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController extends AbstractController<Currency> {

    @Autowired
    private CurrencyService currencyService;

    /**
     * GET ALL
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Currency>> getAll() {
        List<Currency> entities = currencyService.findAll();
        return ackEntities(entities);
    }

    /**
     * GET BY ID
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Currency> findById(@PathVariable("id") String id) {
        Currency entity = currencyService.findById(id);
        return ackEntity(entity);
    }

    /**
     * INSERT CURRENCY
     *
     * @param input
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @CrossOrigin
    public ResponseEntity<Currency> create(@RequestBody Currency input) {
        Currency entity = currencyService.insert(input);
        entity = currencyService.findById(entity.getId()); // Retrieve Node ID
        return ackEntity(entity);
    }

    /**
     * UPDATE CURRENCY
     *
     * @param input
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<Currency> update(@RequestBody Currency input) {
        Currency entity = currencyService.insert(input);
        return ackEntity(entity);
    }

    /**
     * DELTE CURRENCY
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        currencyService.delete(id);
        return ack();
    }

}
