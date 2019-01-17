package com.itheima.dao;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountDaoTest {

    private  AccountDao accountDao = new AccountDaoImpl();

    @Test
    public void add() {
        Account account = new Account();
        account.setUsername("郭靖");
        account.setMoney(100);

        accountDao.add(account);
    }

    @Test
    public void update() {
        Account account = new Account();
        account.setId(1);
        account.setUsername("李寻欢");
        account.setMoney(10000);

        accountDao.update(account);
    }

    @Test
    public void deleteById() {
        accountDao.deleteById(22);
    }

    @Test
    public void findAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {

            System.out.println(account);
        }
    }

    @Test
    public void findById() {
        Account account = accountDao.findById(1);
        System.out.println(account);
    }

    @Test
    public void findTotalCount() {
        int count = accountDao.findTotalCount();
        System.out.println(count);
    }
}