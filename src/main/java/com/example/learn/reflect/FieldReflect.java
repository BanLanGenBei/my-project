package com.example.learn.reflect;

import com.example.learn.reflect.entity.Book;

import java.lang.reflect.Field;

/**
 * 本类功能:Field对象常用的方法
 *
 * @author chenchong
 * @date 2020/12/15 17:24
 */
public class FieldReflect {
    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1);
        book.setName("斗罗大陆");
        book.setType("小说");
//        show(book.getClass());
        show(book);

    }

    /**
     * 使用传递过来的类的对象获取对应的属性的信息
     * @param cla Class对象
     */
    public static void show(Class cla){
        //获取所有的属性的信息
        Field[] declaredFields = cla.getDeclaredFields();

        //只能获取Class对象中的公有的属性
        Field[] fields = cla.getFields();

        for ( Field f : declaredFields ) {
            System.out.println("属性名称:"+f.getName()+"\t"+"属性类型:"+f.getType().getSimpleName());
        }
        System.out.println("=================================================");
        for ( Field field : fields ) {
            System.out.println("属性名称:"+field.getName()+"\t"+"属性类型:"+field.getType().getSimpleName());

        }

    }


    /**
     * 利用传递过来的实体类对象可以获得到对应的属性名已有的属性值
     * @param object 实体类对象
     */
    public static void show(Object object){
        //获取Class对象
        Class cl = object.getClass();
        //获取属性的数组
        Field[] declaredFields = cl.getDeclaredFields();
        for ( Field f : declaredFields) {
            //将每一个当前属性是私有属性可以被外部访问到
            f.setAccessible(true);
            try {
                System.out.println("属性名称:"+f.getName()+"\t"+"属性值:"+f.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
