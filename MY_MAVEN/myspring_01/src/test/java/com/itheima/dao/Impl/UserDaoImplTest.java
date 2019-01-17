package com.itheima.dao.Impl;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void add() {
        //加载配置文件
         ApplicationContext app=new ClassPathXmlApplicationContext("baen.xml");

        //获取业务层对象
        //UserService userService= (UserService) app.getBean("userService");
        //调用业务层方法
        //userService.add();
        User user = (User) app.getBean("user");
        System.out.println(user);
    }
}