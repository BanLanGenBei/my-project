package com.example.learn.reflect;

import com.example.learn.reflect.entity.Book;

/**
 * 本类功能:反射机制
 *
 * Java 反射机制主要提供了以下功能：
 * 在运行时判断任意一个对象所属的类。
 * 在运行时构造任意一个类的对象。
 * 在运行时判断任意一个类所具有的成员变量和方法。
 * 在运行时调用任意一个对象的方法。
 *
 * @author chenchong
 * @date 2020/12/10 20:36
 */
public class ClassReflect {
    public static void main(String[] args){

        Class book1 = null;
        Class book2 = null;
        Class book3 = null;
        //获取class对象的第一种方式: Class.forName("类的全限定名")
        try {
             book1 = Class.forName("com.example.learn.reflect.entity.Book");
            System.out.println("book1 == >"+book1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //获取class对象的第二种方式: 对象.getClass()
        Book book = new Book();
        book2 = book.getClass();
        System.out.println("book2 == >"+book2);

        //获取class对象的第三种方式: 类名.class
        book3 = Book.class;
        System.out.println("book3 == >"+book3);


    }
}
