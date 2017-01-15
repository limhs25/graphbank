package com.bindstone.graphbank.crud;

import com.bindstone.graphbank.domain.Currency;
import com.bindstone.graphbank.provider.CurrencyProvider;
import com.bindstone.graphbank.service.CrudService;
import com.bindstone.graphbank.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class CurrencyCrudTest extends AbstractCrudTest<Currency> {

    @Autowired
    private CurrencyService service;

    @Override
    public Currency getTestClazz() {
        return CurrencyProvider.EURO();
    }

    @Override
    public List<Currency> getTestClazzes() {
        List<Currency> list = new ArrayList<>();
        list.add(CurrencyProvider.EURO());
        list.add(CurrencyProvider.DOLLAR());
        return list;
    }

    @Override
    public CrudService<Currency> getCrudService() {
        return service;
    }
}
