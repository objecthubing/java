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
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 添加用户 --  返回生成的主键
     * @param user
     */
    public void add(User user);

    /**
     * 更新用户  --  如果参数中有数据就更新,如果参数中没有数据就不更新
     * @param user
     */
    public void update(User user);

    /**
     * 批量删除用户
     * @param ids
     */
    public void deleteByIds(Integer... ids);

    /**
     * 查询数据总条数
     * @return
     */
    public int findTotalCount();

    /**
     * 查询所有的用户信息,用户信息中包含所拥有的账户信息
     * @return
     */
    public List<User> findAllWithAccount();

    /**
     * 根据用户名称和密码查询用户
     * @param user
     * @return
     */
    User findByUsernameAndPassword(User user);
}
