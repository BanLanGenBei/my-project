package com.example.learn.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/17 20:18
 */
public class ProxyTest {
    public static void main(String[] args) {
        //创建一个实例对象,这个对象是被代理的对象
        Person zhangsan = new Student("张三");

        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler s = new StuInvocationHandler<Person>(zhangsan);

        //创建一个代理对象stuProxy来代理zhangsan,代理对象的每个执行方法都会替换
//        执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class[]{Person.class},s);

        //代理执行上交班费的方法
        stuProxy.giveMoney();

    }
}
