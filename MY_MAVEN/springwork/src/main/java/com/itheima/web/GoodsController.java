package com.itheima.web;

import com.itheima.domain.Goods;
import com.itheima.domain.ResultInfo;
import com.itheima.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/findByName")
    public @ResponseBody
    ResultInfo fingByName(String goods_name) {
        try {
            Goods good = goodsService.findByName(goods_name);
            if (good != null) {
                return new ResultInfo(true, null, "商品名称已经存在");
            } else {
                return new ResultInfo(false, null, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultInfo(false, null, "系统出bug,联系管理员");
        }
    }

    //添加完后,跳转到查询所有
    @RequestMapping("/add")
    public ModelAndView add(Goods goods) {
        goodsService.add(goods);
        List<Goods> list = goodsService.findAll();
        System.out.println("dao"+list);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("list");
        mav.addObject("list", list);

        return mav;
    }


}

