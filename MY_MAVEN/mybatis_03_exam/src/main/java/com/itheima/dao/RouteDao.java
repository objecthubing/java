package com.itheima.dao;


import com.itheima.domain.Condition;
import com.itheima.domain.Route;
import com.itheima.domain.Seller;

import java.util.List;
import java.util.Map;

public interface RouteDao {


    /**
     * 根据更新数据 --- 对象中有数据的属性更新为新数据  没有数据的属性不更新
     * @param route
     */
    public void update(Route route);

    /**
     * 根据传入的id数组删除线路
     * @param ids
     */
    public void deleteByIds(List<Integer> ids);

    /**
     * 根据id查询数据
     * @param ids
     */
    public List<Route> findByIds(Integer... ids);

    /**
     * 根据条件查询线路数据  ------- 条件可能有也可能没有 {cid:xxx,rname:xxx,minPrice:xxx,maxPrice:xxx}
     * @param condition
     * @return
     */
    public List<Route>  findByCondition(Condition condition);


    /**
     * 查询所有的线路----线路中包含商家信息
     * @return
     */
    List<Route> findAllWithSeller();

    /**
     * 查询所有的线路----线路中包含分类
     * @return
     */
    List<Route> findAllWithCategory();

    /**
     * 查询所有的线路----线路中包含分类
     * @param rid
     * @return
     */
    Route findByRidWithCategory(Integer rid);

    /**
     * 查询所有的线路----线路中包含分类图片信息
     * @param rid
     * @return
     */
    Route findByRidWithImgs(Integer rid);

    /**
     * 查询所有的线路----线路中包含分类图片信息和经销商信息
     * @param rid
     * @return
     */
    Route findByRidWithImgsAndSeller(Integer rid);


}
