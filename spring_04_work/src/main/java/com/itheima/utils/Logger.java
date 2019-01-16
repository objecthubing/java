package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志工具类
 */
public class Logger {

    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        Object value = null;
        try {
            //System.out.println("环绕前=========");
            Object[] args = pjp.getArgs();
            value = pjp.proceed(args);
            //System.out.println("环绕后=========");
            System.out.println("转账成功"+format);
            System.out.println(args[0]+"给"+args[1]+"转账"+args[2]);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
           // System.out.println("环绕异常=========");
            System.out.println("转账失败"+format);
            throw new RuntimeException(throwable);
        }
        return value;
    }
}