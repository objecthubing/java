package com.itheima.service;

import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.utils.TransactionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;


@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService ;

    @Autowired
    private TransactionManager transactionManager ;

    @Test
    public void transfer() throws SQLException {
        accountService.transfer("李寻欢","叶孤城",1000);
    }

}