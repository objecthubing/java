package com.itheima.service.Impl;

import com.itheima.dao.GoodsDao;
import com.itheima.domain.Goods;
import com.itheima.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> findAll() {
        List<Goods> all = goodsDao.findAll();
        System.out.println("service"+all);
        return all;
    }

    @Override
    public void add(Goods goods) {
        goodsDao.add(goods);
    }

    @Override
    public Goods findByName(String goods_name) {
        Goods goods=goodsDao.findByName(goods_name);
        return goods;
    }
}
