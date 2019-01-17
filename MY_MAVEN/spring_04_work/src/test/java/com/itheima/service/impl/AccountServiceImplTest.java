package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;
    @Test
    public void transfer() {
        accountService.transfer("zhangsan","lisi",1000);
    }
}