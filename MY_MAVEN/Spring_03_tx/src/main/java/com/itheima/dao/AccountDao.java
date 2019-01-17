package com.itheima.dao;

import com.itheima.domain.Account;

import java.sql.Connection;
import java.sql.SQLException;

public interface AccountDao {

    /**
     * 根据用户名称查询用户信息
     * @param name
     * @return
     */
    Account findByName(String name) throws SQLException;

    /**
     * 更新账户信息
     * @param source
     */
    void update(Account source) throws SQLException;
}
