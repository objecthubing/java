package com.itheima.web;


import com.itheima.domain.Category;
import com.itheima.domain.ResultInfo;
import com.itheima.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //查询所有的分类
    @RequestMapping("/findAll")
    public @ResponseBody ResultInfo findAll(){
        try {
            List<Category> list=categoryService.findAll();
            //System.out.println("web"+list);
            ResultInfo resultInfo = new ResultInfo(true,list,null);
            return resultInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}
