package com.itheima.dao;

import com.itheima.domain.Route;
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

public class RouteDaoTest {
    private InputStream is;
    private SqlSession sqlSession;
    private RouteDao routeDao;

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
        routeDao= sqlSession.getMapper(RouteDao.class);
    }

    @After//测试方法执行后执行
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        is.close();
    }
    @Test//查询所有旅游线路
    public void findAll() {
        List<Route> all = routeDao.findAll();
        for (Route route : all) {
            System.out.println(route);
        }
    }

    @Test//根据用户输入的字符串,模糊查询线路
    public void findLikeName() {
        List<Route> likeName = routeDao.findLikeName("%西安%");
        for (Route route : likeName) {
            System.out.println(route);
        }
    }

    @Test//根据分类id查询线路信息
    public void findByCid() {
        List<Route> byCid = routeDao.findByCid(5);
        System.out.println(byCid);
    }

    @Test//根据线路id查询线路详情
    public void findByRid() {
        Route byRid = routeDao.findByRid(22);
        System.out.println(byRid);
    }

    @Test//查询数据库中的所有线路数量
    public void findTotalCount() {
        Integer totalCount = routeDao.findTotalCount();
        System.out.println(totalCount);
    }

    @Test//查询数据库中,线路名称包含rname的线路数量
    public void findTotalCount1() {
        Integer totalCount1 = routeDao.findTotalCount1("%兵马俑%");
        System.out.println(totalCount1);
    }

    @Test
    public void findTotalCount2() {
        Integer totalCount2 = routeDao.findTotalCount2(5);
        System.out.println(totalCount2);
    }
}