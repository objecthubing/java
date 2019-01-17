package com.itheima.web;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//交给spring容器管理
@Controller
@RequestMapping("/user")
public class Controller01 {

    @RequestMapping(path ="show",params = {"password"},method = {RequestMethod.GET,RequestMethod.POST})
    public String show(){
        System.out.println("你好世界");
        return "success";
    }

    @RequestMapping(value = "show1",method = {RequestMethod.GET})
    public String show1(User user){
        System.out.println("你好世界1");
        System.out.println(user);
        return "success";
    }
}
