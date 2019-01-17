package com.itheima.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {

    //跟线程绑定的容器 -- 数据库连接就保存在这个容器中
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 在运行过程当中,不论什么时候获取,获取的都是同一个连接
     */
    public Connection getConnection() throws SQLException {
        Connection connection = tl.get();
        //如果线程之中没有连接
        if (connection == null) {
            //从连接池中获取连接
            connection = dataSource.getConnection();
            //将获取的连接保存到线程中,方便后期获取
            tl.set(connection);
        }

        return connection;
    }

    /**
     * 清除线程局部变量中的数据
     */
    public void remove() {
        tl.remove();
    }

}
