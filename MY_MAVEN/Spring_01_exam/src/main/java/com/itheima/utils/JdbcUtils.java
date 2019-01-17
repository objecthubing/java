package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class JdbcUtils {

    private static DataSource dataSource = new ComboPooledDataSource();

    /**
     * 获取连接池的操作
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取连接的操作
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
    }
}
