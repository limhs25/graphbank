package com.bindstone.graphbank.service.impl;

import com.bindstone.graphbank.domain.Country;
import com.bindstone.graphbank.repository.CountryMapper;
import com.bindstone.graphbank.repository.CrudMapper;
import com.bindstone.graphbank.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryServiceImpl extends CrudServiceImpl<Country> implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public CrudMapper getMapper() {
        return countryMapper;
    }
}
