package com.itheima.dao;

import com.itheima.domain.Items;

public interface ItemsDao {

    /**
     * 根据id查询产品信息
     * @param id
     * @return
     */
    public Items findById(Integer id);
}
