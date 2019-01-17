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

import static org.junit.Assert.*;

public class CategoryDaoTest {
    private InputStream is;
    private SqlSession sqlSession;
    private CategoryDao categoryDao;

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
        categoryDao= sqlSession.getMapper(CategoryDao.class);
    }

    @After//测试方法执行后执行
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        is.close();
    }

    @Test//查询所有分类数据
    public void findAll() {
        List<Category> all = categoryDao.findAll();
        for (Category category : all) {
            System.out.println(category);
        }
    }

    @Test//添加一条分类数据
    public void add() {
        Category category = new Category();
        category.setCname("1湖一日游");
        Integer add = categoryDao.add(category);
        System.out.println(category.getCid());
    }

    @Test//根据分类ID,更新分类数据
    public void update() {
        Category category = new Category();
        category.setCid(12);
        category.setCname("北湖一日游");
        categoryDao.update(category);
    }

    @Test//根据id删除分类
    public void delete() {
        categoryDao.delete(12);
    }
}