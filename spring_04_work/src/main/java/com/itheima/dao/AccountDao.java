package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {


    Account findByName(String username1);

    void update(Account account1);
}
