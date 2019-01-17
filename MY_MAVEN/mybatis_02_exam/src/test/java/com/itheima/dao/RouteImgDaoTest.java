package com.itheima.dao;
import com.itheima.domain.RouteImg;
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


public class RouteImgDaoTest {
    private InputStream is;
    private SqlSession sqlSession;
    private RouteImgDao routeImgDao;


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
        routeImgDao= sqlSession.getMapper(RouteImgDao.class);
    }

    @After//测试方法执行后执行
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        is.close();
    }

    @Test
    public void findByRid() {
        List<RouteImg> imgs = routeImgDao.findByRid(1);
        System.out.println(imgs);
    }
}