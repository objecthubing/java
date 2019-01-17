package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
@Component
public class UserServiceTest {

    private UserService userService;

    @Before
    public void init(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
         userService = (UserService) applicationContext.getBean("userService");
    }

    @Test
    public void add() throws SQLException {
        User user = new User();
        user.setUsername("西门吹雪");
        user.setSex("男");
        user.setAddress("梁山");
        user.setBirthday(new Date());
        userService.add(user);
    }

    @Test
    public void update() throws SQLException {
        User user = new User();
        user.setUsername("叶孤城");
        user.setSex("男");
        user.setAddress("梁山");
        user.setBirthday(new Date());
        user.setId(55);

        userService.update(user);
    }

    @Test
    public void delete() throws SQLException {
        userService.delete(41);
    }

    @Test
    public void findAll() throws SQLException {
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findById() throws SQLException {
        User user = userService.findById(54);
        System.out.println(user);
    }

    @Test
    public void findTotalCount() throws SQLException {
        Integer totalCount = userService.findTotalCount();
        System.out.println(totalCount);

    }
}