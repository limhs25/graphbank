package com.bindstone.graphbank.service.impl;

import com.bindstone.graphbank.service.MoneyDrawerService;
import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class MoneyDrawerServiceImpl implements MoneyDrawerService {
    private static Logger log = LoggerFactory.getLogger(MoneyDrawerServiceImpl.class);

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void draw(Double value) {
        Map<String, Object> variables = new HashMap<String, Object>();
        //variables.put("applicant", applicant);
        runtimeService.startProcessInstanceByKey("redraw_money", variables);
    }
}
