package com.itheima.dao;

import com.itheima.domain.Condition;
import com.itheima.domain.Route;
import com.itheima.domain.Seller;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteDaoTest {
    private SqlSession session;
    private InputStream is;
    private RouteDao routeDao;

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
        routeDao = session.getMapper(RouteDao.class);
    }

    @After
    public void destroy() throws IOException {
        //提交事物
        session.commit();
        //6. 释放资源
        session.close();
        is.close();
    }


    @Test//根据更新数据 --- 对象中有数据的属性更新为新数据  没有数据的属性不更新
    public void update() {
        Route route = new Route();
        route.setRid(514);
        route.setCount(2);
        route.setRname("22");
        routeDao.update(route);
    }

    @Test//根据传入的id数组删除线路
    public void deleteByIds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(515);
        list.add(516);
        routeDao.deleteByIds(list);
    }

    @Test//根据id查询数据
    public void findByIds() {
        List<Route> byIds = routeDao.findByIds(1, 5);
        for (Route byId : byIds) {
            System.out.println(byId);
        }
    }

    @Test//根据条件查询线路数据
    public void findByCondition() {
        Condition condition = new Condition();
        condition.setCid(5);
        condition.setMinPrice(1111.1);
        condition.setMaxPrice(2222.2);
        List<Route> byCondition = routeDao.findByCondition(condition);
        for (Route route : byCondition) {
            System.out.println(route);
        }
    }

    @Test//查询所有的线路----线路中包含商家信息
    public void findAllWithSeller() {
        List<Route> all = routeDao.findAllWithSeller();
        for (Route seller : all) {
            System.out.println(seller);
        }

    }

    @Test
    public void findByRidWithImgsAndSeller() {
        Route route = routeDao.findByRidWithImgsAndSeller(5);
        System.out.println(route);
    }
}
