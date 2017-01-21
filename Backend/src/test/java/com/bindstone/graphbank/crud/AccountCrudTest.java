package com.bindstone.graphbank.crud;

import com.bindstone.graphbank.domain.Account;
import com.bindstone.graphbank.provider.AccountProvider;
import com.bindstone.graphbank.service.AccountService;
import com.bindstone.graphbank.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class AccountCrudTest extends AbstractCrudTest<Account> {

    @Autowired
    private AccountService service;

    @Override
    public Account getTestClazz() {
        return AccountProvider.POSITVE_ACCOUNT();
    }

    @Override
    public List<Account> getTestClazzes() {
        List<Account> list = new ArrayList<>();
        list.add(AccountProvider.POSITVE_ACCOUNT());
        list.add(AccountProvider.NEGATIVE_ACCOUNT());
        return list;
    }

    @Override
    public CrudService<Account> getCrudService() {
        return service;
    }
}
