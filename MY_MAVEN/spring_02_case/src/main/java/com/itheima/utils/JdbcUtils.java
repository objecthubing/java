package com.itheima.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private  static DataSource dataSource ;

    static {
        try {
            //1. 创建properties对象
            Properties properties = new Properties();
            //2. 读取配置文件
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("duid.properties");
            //3. 加载配置文件数据到properties对象中
            properties.load(is);

            //4. 创建连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
    }

    //获取连接池
    public static DataSource getDataSource(){
        return  dataSource ;
    }

}
