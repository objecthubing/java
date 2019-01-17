package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UserDaoTest {

    private SqlSession session;
    private InputStream is;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        //1. 创建sqlSessionBuilder构造者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //2. 创建SqlSessionFactory对象
        //2.1 加载配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.2 构建SqlSession工厂
        SqlSessionFactory sf = builder.build(is);

        //3. 获取SqlSession对象
        session = sf.openSession();

        //4. 获取mapper类的代理对象
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        //提交事物
        session.commit();
        //6. 释放资源
        session.close();
        is.close();
    }

    @Test//查询所有用户信息
    public void findAll() {
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.err.println(user);
        }
    }

    @Test
    public void findById() {
        User byId = userDao.findById(33);
        System.out.println(byId);
    }


    @Test
    public void add() {
        User user = new User();
        user.setUsername("q111wer");
        user.setPassword("1234");
        user.setSex("男");
        int add = userDao.add(user);
        System.out.println("生成的主键id"+user.getUid());
    }
}