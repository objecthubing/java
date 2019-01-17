package com.itheima.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService accountService ;

    @Test
    public void saveAccount() {
        accountService.saveAccount();
    }

    @Test
    public void updateAccount() {
        accountService.updateAccount(1);
    }

    @Test
    public void delAccount() {
        int i = accountService.delAccount();
        System.out.println(i);
    }
}
