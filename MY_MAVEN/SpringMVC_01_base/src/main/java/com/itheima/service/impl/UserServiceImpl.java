package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteByIds(Integer... ids) {
        userDao.deleteByIds(ids);
    }

    @Override
    public int findTotalCount() {
        return userDao.findTotalCount();
    }

    @Override
    public List<User> findAllWithAccount() {
        return userDao.findAllWithAccount();
    }

    @Override
    public User findByUsernameAndPassword(User user) {
        return userDao.findByUsernameAndPassword(user);
    }
}
