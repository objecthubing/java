package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

public class AccountServiceImpl implements AccountService{

    private  AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //转账操作
    public void transfer(String username1, String username2, double money) {
        //查询一号账户
        Account account1=accountDao.findByName(username1);
        //查询2号账户
        Account account2=accountDao.findByName(username2);
        //一号账户减钱
        account1.setMoney(account1.getMoney()-money);
        //更新账户
        accountDao.update(account1);

        //int i =10/0;
        //一号账户加钱
        account2.setMoney(account2.getMoney()+money);
        //更新账户
        accountDao.update(account2);

    }
}
