package com.bindstone.graphbank.service.impl;

import com.bindstone.graphbank.domain.Account;
import com.bindstone.graphbank.repository.AccountMapper;
import com.bindstone.graphbank.repository.CrudMapper;
import com.bindstone.graphbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl extends CrudServiceImpl<Account> implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public CrudMapper getMapper() {
        return accountMapper;
    }
}
