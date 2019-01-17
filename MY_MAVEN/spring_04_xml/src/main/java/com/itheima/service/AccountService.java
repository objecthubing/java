package com.itheima.service;

import com.itheima.domain.Account;

import javax.security.auth.login.AccountException;
import java.util.List;

public interface AccountService {

    //转账操作
    public void transfer(String username1,String username2,double money);
}
