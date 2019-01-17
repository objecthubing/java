package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
//@ContextConfiguration(locations = "classpath:beans.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceImplTest {
    //private AccountService accountService = new AccountServiceImpl();

    @Test
    public void transfer() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.transfer("zhangsan","lisi",1000);
    }
}