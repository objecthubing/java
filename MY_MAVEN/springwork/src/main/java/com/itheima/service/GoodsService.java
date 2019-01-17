package com.itheima.service;

import com.itheima.domain.Goods;

import java.util.List;

public interface GoodsService {
    //查询所有
    public List<Goods> findAll();

    //添加
    public void add(Goods goods);

    //添加时查询是否重fu
    public Goods findByName(String goods_name);

}
