package com.itheima.service.impl;

import com.itheima.domain.Account;
import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

import java.sql.SQLException;


public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String sourceName, String targetName, double money) throws SQLException {
        //1.根据名称查询转出账户
        Account source = accountDao.findByName(sourceName);
        //2.根据名称查询转入账户
        Account target = accountDao.findByName(targetName);
        //3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        //4.转入账户加钱
        target.setMoney(target.getMoney() + money);
        //5.更新转出账户余额
        accountDao.update(source);
        //int i = 10 / 0; //特意添加的异常代码,让程序执行异常
        //6.更新转入账户余额
        accountDao.update(target);
    }

    @Override
    public void update(Account account) throws SQLException {
        accountDao.update(account);
    }

    @Override
    public void add(Account account) {

    }

}
