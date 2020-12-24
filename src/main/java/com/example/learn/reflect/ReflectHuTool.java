package com.example.learn.reflect;

import cn.hutool.core.util.ReflectUtil;
import com.example.learn.reflect.entity.Book;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/15 19:29
 */
public class ReflectHuTool {
    public static void main(String[] args) {
        Book book = new Book(3,"chen","科幻");
        
        //获取某个类的所有的属性
        Field[] fields = ReflectUtil.getFields(Book.class);

        //获取所有的方法
        Method[] methods = ReflectUtil.getMethods(Book.class);

        //获取指定的方法
        Method test = ReflectUtil.getMethodByName(Book.class, "test");

        //获取方法并且执行该方法(对象,方法名,参数)
        Object invoke = ReflectUtil.invoke(book, "test", "chen", "chong");


        //获取类中的某个属性的值(对象,属性的名称)
        Object name = ReflectUtil.getFieldValue(book, "name");

        //通过获取类的构造方法,并且创建一个对象实例
        Constructor<? extends Book> constructor = ReflectUtil.getConstructor(book.getClass(), Integer.class, String.class, String.class);
        try {
            Book book1 = constructor.newInstance(5, "chenchong", "888888");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //直接构造出对象
        Book book1 = ReflectUtil.newInstance(Book.class, 5, "dadadadadada", "xiaoshuo");




    }
}
