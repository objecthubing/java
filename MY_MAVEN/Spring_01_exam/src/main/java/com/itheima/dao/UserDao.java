package com.itheima.dao;

import com.itheima.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    /**
     * 添加用户
     * @param user
     */
    void add(User user) ;

    /**
     * 更新用户
     * @param user
     */
    void update(User user);

    /**
     * 删除用户
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id) ;

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

}
