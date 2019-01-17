package com.itheima.utils;

import java.sql.SQLException;

public class TransactionManager {

    private  JdbcUtils jdbcUtils ;

    public void setJdbcUtils(JdbcUtils jdbcUtils) {
        this.jdbcUtils = jdbcUtils;
    }

    /**
     * 开启事物
     */
    public void startTransaction() {
        try {
            jdbcUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事物
     */
    public void commitTransaction() {
        try {
            jdbcUtils.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事物
     */
    public void rollbackTransaction() {
        try {
            jdbcUtils.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 释放资源
     */
    public void release() {
        try {
            jdbcUtils.getConnection().close();
            jdbcUtils.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
