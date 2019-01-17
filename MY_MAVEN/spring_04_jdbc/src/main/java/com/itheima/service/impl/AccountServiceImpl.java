package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao  ;

    @Override
    public void add(Account account) {
        accountDao.add(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void deleteById(int id) {
        accountDao.deleteById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public int findTotalCount() {
        return accountDao.findTotalCount();
    }

    @Override
    public void transfer(String sourceName, String targetName, double money) {
        //1. 转出账户扣钱
        //1.1 查询转出账户
        Account source = accountDao.findByName(sourceName);
        //1.2 从转出账户扣钱
        source.setMoney(source.getMoney()-money);
        //1.3 更新数据库数据
        accountDao.update(source);

        //int i = 10 /0 ;

        //2. 转入账户加钱
        //2.1 查询转入账户
        Account target = accountDao.findByName(targetName);
        //2.2 给转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.3 更新数据库数据
        accountDao.update(target);
    }
}
