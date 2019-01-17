package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    //查询所有用户
    //ctrl+shift+t生成测试类
   public List<User>findAll();

    //添加
    public void add(User user);

    //修改用户
    public void update(User user);

    //删除用户
    public void delete(Integer id);

    //查询单个用户
    public User findById(Integer id);

    //模糊查询
    public List<User> findByName(String name);

    //查询用户总个数
    public int findCount();

}
