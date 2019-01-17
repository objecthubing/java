package com.itheima.dao.impl;

import com.itheima.domain.User;
import com.itheima.dao.UserDao;
import com.itheima.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


/**
 * 使用DbUtils 完成CRUD
 *  DbUtils的核心对象  QueryRuuner
 *  创建核心对象   public QueryRunner(DataSource ds)
 *  查询:  public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
 *  增删改: public int update(String sql, Object... params)
 *
 *ResultSetHandler 结果集处理类
 *    BeanHandler : 适用于查询一条数据,将查询到的一条数据封装到一个javabean中(javabean的属性名称必须和数据库字段一致)
 *    BeanListHandler : 适用于查询多条数据,将查询到的一条数据封装到一个javabean中(javabean的属性名称必须和数据库字段一致),将多条数据的多个javaBean封装到一个List集合中
 *    ScalarHandler :适用于单值数据封装(查询结果是一行一列)
 *
 *
 * 另外一组方法:
 *  创建核心对象   public QueryRunner()
 *  查询:  public <T> T query(Connection conn,String sql, ResultSetHandler<T> rsh, Object... params)
 *  增删改: public int update(Connection conn,String sql, Object... params)
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    //创建 DbUtils的核心对象
    @Autowired
    private QueryRunner queryRunner;

    @Override
    public void add(User user) throws SQLException {
        String sql = "insert into user values(null,?,?,?,?)";
        queryRunner.update(sql,user.getUsername(),user.getBirthday(),user.getSex(),user.getAddress());

    }

    @Override
    public void update(User user) throws SQLException {
        String sql = "update user set username=?,birthday=?,sex=?,address=? where id = ? ";
        queryRunner.update(sql,user.getUsername(),user.getBirthday(),user.getSex(),user.getAddress(),user.getId());
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "delete from user where id = ? ";
        queryRunner.update(sql,id);
    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = "select * from user ";
        List<User> users = queryRunner.query(sql, new BeanListHandler<User>(User.class));
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        String sql = "select * from user where id = ?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), id);
        return user;
    }

    @Override
    public Integer findTotalCount() throws SQLException {
        String sql = "select count(*) from user" ;
        Long count = (Long)queryRunner.query(sql, new ScalarHandler());
        return count.intValue();
    }
}
