package com.bindstone.graphbank.controller;


import com.bindstone.graphbank.domain.Currency;
import com.bindstone.graphbank.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class DatabaseController extends AbstractController<Currency> {

    @Autowired
    private DatabaseService databaseService;

    /**
     * ACTION clear
     *
     * @return
     */
    @RequestMapping(value = "/action/clear", method = RequestMethod.DELETE)
    @CrossOrigin
    public ResponseEntity<Void> clearDatabase() {
        databaseService.clear();
        return ack();
    }

}
