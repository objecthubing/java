package com.itheima.dao.impl;

import com.itheima.domain.Account;
import com.itheima.dao.AccountDao;
import com.itheima.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;


public class AccountDaoImpl implements AccountDao {

    private QueryRunner queryRunner ;

    private  JdbcUtils jdbcUtils ;

    public void setJdbcUtils(JdbcUtils jdbcUtils) {
        this.jdbcUtils = jdbcUtils;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public Account findByName(String name) throws SQLException {
        String sql = "select * from account where username = ? ";
        return queryRunner.query(jdbcUtils.getConnection(),sql, new BeanHandler<Account>(Account.class), name);
    }

    @Override
    public void update(Account account) throws SQLException {
        String sql = "update account set money = ? where username = ? ";
        queryRunner.update(jdbcUtils.getConnection(),sql, account.getMoney(), account.getUsername());
    }
}
