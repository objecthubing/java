package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 添加账户
     * @param account
     */
    public void add(Account account);


    /**
     * 更新账户
     * @param account
     */
    public void update(Account account);

    /**
     * 根据id进行删除
     * @param id
     */
    public void deleteById(int id);

    /**
     * 查询所有账户信息
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据账户id查询账户信息
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 查询数据总量
     * @return
     */
    public int findTotalCount();

    /**
     * 转账功能
     * @param sourceName
     * @param targetName
     * @param money
     */
    public void transfer(String sourceName,String targetName ,double money);
}
