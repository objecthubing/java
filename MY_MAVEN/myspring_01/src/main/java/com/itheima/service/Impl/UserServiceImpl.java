package com.itheima.service.Impl;

import com.itheima.dao.Impl.UserDaoImpl;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {
    private  UserDaoImpl userDao = new UserDaoImpl();

    public void add() {
        userDao.add();
    }
}
