package com.bindstone.graphbank.controller;


import com.bindstone.graphbank.domain.Country;
import com.bindstone.graphbank.service.CountryService;
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
@RequestMapping("/country")
public class CountryController extends AbstractController<Country> {

    @Autowired
    private CountryService countryService;

    /**
     * GET ALL
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Country>> getAll() {
        List<Country> entities = countryService.findAll();
        return ackEntities(entities);
    }

    /**
     * GET BY ID
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Country> findById(@PathVariable("id") String id) {
        Country entity = countryService.findById(id);
        return ackEntity(entity);
    }

    /**
     * INSERT COUNTRY
     *
     * @param input
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @CrossOrigin
    public ResponseEntity<Country> create(@RequestBody Country input) {
        Country entity = countryService.insert(input);
        entity = countryService.findById(entity.getId()); // Retrieve Node ID
        return ackEntity(entity);
    }

    /**
     * UPDATE COUNTRY
     *
     * @param input
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<Country> update(@RequestBody Country input) {
        Country entity = countryService.insert(input);
        return ackEntity(entity);
    }

    /**
     * DELTE COUNTRY
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin
    public ResponseEntity<Void>  delete(@PathVariable("id") String id) {
        countryService.delete(id);
        return ack();
    }

}
