package com.itheima.service;

import com.itheima.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    /**
     *添加用户
     * @param user
     */
    public void add(User user) throws SQLException;

    /**
     * 更新用户
     * @param user
     */
    public  void update(User user) throws SQLException;

    /**
     * 删除用户
     * @param id
     */
    public void delete(Integer id) throws SQLException;

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll() throws SQLException;

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public User findById(Integer id) throws SQLException;

    /**
     * 查询数据条数
     * @return
     */
    public Integer findTotalCount() throws SQLException;
}
