package com.itheima.dao;

import com.itheima.domain.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * 查询所有分类信息,分类中包含线路
     * @return
     */
    List<Category> findAllWithRoutes();

    /**
     * 根据分类id查询分类,分类中包含线路信息
     * @return
     */
    Category findByCidWithRoutes(Integer cid);
}
