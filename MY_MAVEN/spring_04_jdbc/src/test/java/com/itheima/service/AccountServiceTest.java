package com.itheima.service;

import com.itheima.domain.Account;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService ;

    @Test
    public void add() {
        Account account = new Account();
        account.setUsername("郭靖");
        account.setMoney(100);

        accountService.add(account);
    }

    @Test
    public void update() {
        Account account = new Account();
        account.setId(1);
        account.setUsername("李寻欢");
        account.setMoney(10000);

        accountService.update(account);
    }

    @Test
    public void deleteById() {
        accountService.deleteById(22);
    }

    @Test
    public void findAll() {
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {

            System.out.println(account);
        }
    }

    @Test
    public void findById() {
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void findTotalCount() {
        int count = accountService.findTotalCount();
        System.out.println(count);
    }

    @Test
    public void transfer() {

        accountService.transfer("zhangsan","lisi",1000);
    }
}