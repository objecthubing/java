package com.itheima.dao;

import com.itheima.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {


    /**
     * 根据线路id查询线路图片信息
     * @param rid
     * @return
     */
    List<RouteImg> findByRid(Integer rid);

}
