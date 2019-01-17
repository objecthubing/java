package com.itheima.utils;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {

    private static DruidDataSource dataSource ;


    static {
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("ROOT");
    }

    public static  DataSource getDataSource(){
        return dataSource ;
    }

    public static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
    }

}
