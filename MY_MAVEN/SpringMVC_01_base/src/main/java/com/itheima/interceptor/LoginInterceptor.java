package com.itheima.interceptor;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.ResultInfo;
import com.itheima.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//自定义的拦截器
public class LoginInterceptor implements HandlerInterceptor {
    //方法执行前执行
    /*@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession();
        //判断session中是否存在用户
        User user = (User) session.getAttribute("user");
        //判断是否登陆
        if (user==null){
            //未登录回写错误信息
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setMsg("用户未登录");
            resultInfo.setStatus(0);
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getWriter(),resultInfo);
            return false;
        }
        return true;
    }*/
}
