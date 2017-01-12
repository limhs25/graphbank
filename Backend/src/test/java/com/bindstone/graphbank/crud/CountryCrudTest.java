package com.bindstone.graphbank.crud;

import com.bindstone.graphbank.domain.Country;
import com.bindstone.graphbank.provider.CountryProvider;
import com.bindstone.graphbank.service.CountryService;
import com.bindstone.graphbank.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class CountryCrudTest extends AbstractCrudTest<Country> {

    @Autowired
    private CountryService service;

    @Override
    public Country getTestClazz() {
        return CountryProvider.LUXEMBOURG();
    }

    @Override
    public List<Country> getTestClazzes() {
        List<Country> list = new ArrayList<>();
        list.add(CountryProvider.LUXEMBOURG());
        list.add(CountryProvider.ICELAND());
        return list;
    }

    @Override
    public CrudService<Country> getCrudService() {
        return service;
    }
}
