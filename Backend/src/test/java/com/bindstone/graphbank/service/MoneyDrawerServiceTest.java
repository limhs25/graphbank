package com.bindstone.graphbank.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@Transactional
public class MoneyDrawerServiceTest {

    @Autowired
    private MoneyDrawerService moneyDrawerService;

    @Test
    public void test() {
        try {
            moneyDrawerService.draw(10d);
        } catch (Exception e) {
            Assert.fail("Unexpected error" + e);
        }
    }
}
