package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void init(){
        //读取配置文件,创建容器
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        //从容器中获取对象
         userService = app.getBean("userService", UserService.class);
    }
    @Test
    public void add() throws SQLException {
        //创建用户对象
        User user = new User();
        user.setUsername("张翠山");
        user.setAddress("金融港");
        user.setSex("男");
        user.setBirthday(new Date());
        userService.add(user);
    }

    @Test
    public void update() throws SQLException {
        //创建用户对象
        User user = new User();
        user.setId(50);
        user.setUsername("张无忌");
        user.setAddress("金融港");
        user.setSex("男");
        user.setBirthday(new Date());
        userService.update(user);
    }

    @Test
    public void delete() throws SQLException {

        userService.delete(48);
    }

    @Test
    public void findById() throws SQLException {
        User user = userService.findById(45);
        System.out.println(user);
    }

    @Test
    public void findAll() throws SQLException {
        List<User> users = userService.findAll();
        for (User user : users) {
            System.err.println(user);
        }
    }
}