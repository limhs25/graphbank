package com.bindstone.graphbank.service.impl;

import com.bindstone.graphbank.domain.Currency;
import com.bindstone.graphbank.repository.CrudMapper;
import com.bindstone.graphbank.repository.CurrencyMapper;
import com.bindstone.graphbank.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CurrencyServiceImpl extends CrudServiceImpl<Currency> implements CurrencyService {

    @Autowired
    CurrencyMapper currencyMapper;

    @Override
    public CrudMapper getMapper() {
        return currencyMapper;
    }
}
