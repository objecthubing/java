package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    public void add(User user);

    /**
     * 更新用户
     * @param user
     */
    public void update(User user);

    /**
     * 模糊查询用户
     * @return
     */
    public List<User> findByName(User user);
}
