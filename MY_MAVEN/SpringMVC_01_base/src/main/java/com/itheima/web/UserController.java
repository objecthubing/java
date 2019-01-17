package com.itheima.web;


import com.itheima.domain.ResultInfo;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(path = "/login")
    public @ResponseBody ResultInfo login(User user, HttpSession session){
        User logined = userService.findByUsernameAndPassword(user);
        if(logined==null){
            return new ResultInfo(0,"用户名或密码错误");
        }

        session.setAttribute("loginedUser",logined);
        return new ResultInfo(1,logined);
    }

    //查询所有
    @RequestMapping(value = "findAll")
    public @ResponseBody ResultInfo findAll(){
        List<User> all = userService.findAll();
        System.out.println(all);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setStatus(1);
        resultInfo.setData(all);
        return resultInfo;
    }
}
