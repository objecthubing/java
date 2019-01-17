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

    @Test//查询所有
    public void findAll() {
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test//添加数据
    public void add() {
        User user = new User();
        user.setUsername("1111羊羊");
        user.setPassword("123456");
        user.setName("羊羊");
        user.setBirthday("2018-01-01");
        user.setSex("男");
        user.setTelephone("1111");
        user.setEmail("123");
        user.setStatus("yes");
        user.setCode("qa1z1s");
        userDao.add(user);
        int uid = user.getUid();
        System.out.println(uid);
    }

    @Test
    public void update() {
        User user = new User();
        user.setUid(42);
        //user.setUsername("懒羊");
        user.setPassword("123456");
        user.setName("小羊");
        user.setBirthday("2018-01-01");
        user.setSex("男");
        user.setTelephone("1111");
        user.setEmail("123");
        user.setStatus("yes");
        //user.setCode("qwerty123");
        userDao.update(user);
    }
}
