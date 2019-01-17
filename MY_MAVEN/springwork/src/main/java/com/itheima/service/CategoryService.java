package com.itheima.service;


import com.itheima.domain.Category;

import java.util.List;

public interface CategoryService {
    //查询所有的分类
    List<Category> findAll();

    Category findById(String cid);
}
