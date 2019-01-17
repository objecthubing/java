package com.itheima.dao;

import com.itheima.domain.Category;
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

public class CategoryDaoTest {
    private SqlSession session;
    private InputStream is;
    private CategoryDao categoryDao;

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
        session = sf.openSession(true);

        //4. 获取mapper类的代理对象
        categoryDao = session.getMapper(CategoryDao.class);
    }

    @After
    public void destroy() throws IOException {
        //提交事物
        //session.commit();
        //6. 释放资源
        session.close();
        is.close();
    }


    @Test//查询所有分类信息,分类中包含线路
    public void findAllWithRoutes() {
        List<Category> list = categoryDao.findAllWithRoutes();
        for (Category category : list) {
            System.out.println(category);
        }
    }

    @Test//根据分类id查询分类,分类中包含线路信息
    public void findByCidWithRoutes() {
        Category cidWithRoutes = categoryDao.findByCidWithRoutes(4);
        System.out.println(cidWithRoutes);
    }
}