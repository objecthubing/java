package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.List;

public class AccountDaoImpl implements AccountDao {


    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findByName(String username) {
        try {
            String sql="select * from account where username = ?";
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Account>(Account.class),username);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Account account) {
        String sql="update account set username = ? ,money = ? where id = ?";
        jdbcTemplate.update(sql,account.getUsername(),account.getMoney(),account.getId());
    }
}
