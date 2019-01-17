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
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    private InputStream is;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before//测试方法执行之前执行
    public void init() throws Exception {
        //1:加载配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2:创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //获取sqlSessiog工厂对象
        SqlSessionFactory sf = builder.build(is);
        //获取sqlSession对象
        sqlSession = sf.openSession();
        //使用sqlSession创建dao接口的实现类对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After//测试方法执行后执行
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        is.close();
    }

    @Test//查询所有用户
    public void findAll() throws Exception {
        //使用代理类查询方法
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }

    @Test//添加用户
    public void add() {
        User user = new User();
        user.setUsername("喜羊羊");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("1005");
        userDao.add(user);
        System.out.println(user.getId());
    }

    @Test//修改用户
    public void update() {
        User user = new User();
        user.setId(47);
        user.setUsername("贼帅");
        user.setAddress("1005");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.update(user);
    }

    @Test//删除用户
    public void delete() {
        userDao.delete(43);
    }

    @Test//查询单个用户
    public void findById() {
        User byId = userDao.findById(46);
        System.out.println(byId);
    }

    @Test//根据id模糊查询
    public void findByName() {
        List<User> byName = userDao.findByName("%王%");
        System.out.println(byName);
    }

    @Test//查询用户总个数
    public void findCount() {
        int count = userDao.findCount();
        System.out.println(count);
    }
}