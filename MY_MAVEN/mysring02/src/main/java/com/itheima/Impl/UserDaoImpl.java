package com.itheima.Impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class UserDaoImpl implements UserDao {

    public void add() {
        System.out.println("数据访问层方法执行");
    }
}
