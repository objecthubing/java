package com.itheima.dao;

import com.itheima.domain.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsDao {

    //查询所有
    @Select("select * from tbl_goods")
    @Results({
            @Result(id = true, column = "goods_id", property = "goods_id"),
            @Result(column = "goods_number", property = "goods_number"),
            @Result(column = "goods_price", property = "goods_price"),
            @Result(column = "guarantee_period", property = "guarantee_period"),
            @Result(column = "cid", property = "cid"),
            @Result(column    = "cid", property = "category", one = @One(select = "com.itheima.dao.CategoryDao.findById"))
    })
    public List<Goods> findAll();

    //添加
    @Insert("insert into tbl_goods values(null,#{goods_name},#{goods_number},#{goods_price},#{guarantee_period},#{cid})")
    public void add(Goods goods);

    @Select("select * from tbl_goods where goods_name = #{goodsName}")
    public Goods findByName(String goods_name);

}
