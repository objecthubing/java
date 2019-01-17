package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;

public class AccountServiceImpl implements AccountService {

    /**
     * 模拟保存
     */
    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    /**
     * 模拟修改
     */
    @Override
    public void updateAccount(int i) {
        System.out.println("执行了修改"+i);
    }

    /**
     * 模拟删除
     */
    @Override
    public int delAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
