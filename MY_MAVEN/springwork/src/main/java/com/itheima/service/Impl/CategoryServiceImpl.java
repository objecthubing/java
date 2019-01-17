package com.itheima.service.Impl;

import com.itheima.dao.CategoryDao;
import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> findAll() {
        List<Category> all = categoryDao.findAll();
        //System.out.println("service"+all);
        return all;
    }

    @Override
    public Category findById(String cid) {

        return categoryDao.findById(cid);
    }
}
