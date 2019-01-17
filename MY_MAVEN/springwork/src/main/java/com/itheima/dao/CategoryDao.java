package com.itheima.dao;

import com.itheima.domain.Category;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryDao {

    @Select("select * from tbl_category")
    public List<Category>findAll();
    //查询所有
    @Select("select * from tbl_category where cid = #{cid}")
    Category findById(String cid);

}
