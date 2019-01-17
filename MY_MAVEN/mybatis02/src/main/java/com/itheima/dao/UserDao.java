package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    //查询所有
    @Select("select * from tab_user")
    public List<User> findAll();

    //根据id查询单个用户
    @Select("select * from tab_user where uid = #{uid}")
    public User findById(int uid);

    //添加用户
    @Insert("insert into tab_user(username,password,sex) values (#{username},#{password},#{sex})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "uid", keyColumn = "uid", resultType = int.class, before = false)
    public int add(User user);

    //根据用户表,查询收藏线路
    @Select("select * from tab_user")
    @Results(id = "userMap",
            value = {
            @Result(id = true,property = "id",column ="id" ),
            @Result(column = "",property = ""),
                }
    )
    public List<User> findAll1();
}
