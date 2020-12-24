package com.example.learn.proxy.statics;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/17 19:52
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        //张三
        Person zhangsan = new Student("张三");
        //班长
        Person monitor = new StudentProxy(zhangsan);

        monitor.giveMoney();
}

    }