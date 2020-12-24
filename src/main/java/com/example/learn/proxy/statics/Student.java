package com.example.learn.proxy.statics;

/**
 * 本类功能:一个实现了接口类的实体类
 *
 *
 * @author chenchong
 * @date 2020/12/17 19:42
 */
public class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    @Override
    public void giveMoney() {
        System.out.println(name + "上交班费50元");

    }
}
