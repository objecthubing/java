package com.itheima.service;

import com.itheima.domain.Account;

import java.sql.SQLException;

public interface AccountService {

    /**
     * 转账业务功能
     *
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money      转账金额
     * @throws SQLException
     */
    public void transfer(String sourceName, String targetName, double money) throws SQLException;

    public void update(Account account) throws SQLException;

    public void add(Account account);
}
