package com.itheima.dao.impl;

import com.itheima.domain.User;
import com.itheima.dao.UserDao;
import com.itheima.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate ;
    //构造方法注入值


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(User user) {
        String sql = "insert  into `user` values (null,?,?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getBirthday(), user.getSex(), user.getAddress());
    }

    @Override
    public void update(User user){
        String sql = "update user set username = ? ,birthday = ? ,sex = ? ,address = ? where id = ? ";
        jdbcTemplate.update(sql, user.getUsername(), user.getBirthday(), user.getSex(), user.getAddress(), user.getId());
    }

    @Override
    public void delete(Integer id){
        String sql = "delete from user where id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User findById(Integer id){
        String sql = "select * from user where id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll(){
        String sql = "select * from user ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }
}
