package com.example.learn.proxy.dynamic;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/17 20:11
 */
public class StuInvocationHandler<T> implements InvocationHandler {
    //invocationHandler持有被代理的对象
    T target;

    public StuInvocationHandler(T target){
        this.target = target;
    }

    /**
     *
     * @param proxy 代表动态代理对象
     * @param method 代表正在执行的方法
     * @param args 代表调用目标方法是传入的实参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");

        //代理过程中插入监测方法,计算该方法的耗时的时间
        TimeInterval timer = DateUtil.timer();
        Object result = method.invoke(target, args);
        long l = timer.intervalMs();
        System.out.println(l);
        return result;

    }
}
