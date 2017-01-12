package com.bindstone.graphbank.service.impl;

import com.bindstone.graphbank.repository.DatabaseMapper;
import com.bindstone.graphbank.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DatabaseServiceImpl implements DatabaseService {

    @Autowired
    DatabaseMapper databaseMapper;

    @Override
    public void clear() {
        databaseMapper.clear();
    }

    @Override
    public void initData() {
        databaseMapper.initData();
    }
}
