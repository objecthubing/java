package com.itheima.Impl;

import com.itheima.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void add() {
        //加载配置文件
        ApplicationContext app=new ClassPathXmlApplicationContext("beans.xml");
        //调用业务层方法
        //userService.add();
        UserDao userdao = app.getBean("userDaoImpl",UserDao.class);
        userdao.add();

    }
}