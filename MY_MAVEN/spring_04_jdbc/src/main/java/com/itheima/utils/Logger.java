package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志工具类
 */
public class Logger {

    public void beforePrintLog() {
        System.out.println("前置=========");
    }

    public void afterReturningPrintLog() {
        System.out.println("后置=========");
    }

    public void afterThrowingPrintLog() {
        System.out.println("异常=========");
    }

    public void after() {
        System.out.println("最终=========");
    }

    public Object aroundPrintLog(ProceedingJoinPoint pjp) {

        Object value = null;
        try {
            System.out.println("环绕前=========");

            Object[] args = pjp.getArgs();
            value = pjp.proceed(args);

            System.out.println("环绕后=========");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕异常=========");
        } finally {
            System.out.println("环绕最终=========");
        }

        return value;

    }


}

