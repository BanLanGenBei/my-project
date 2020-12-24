package com.example.learn.reflect;

import com.example.learn.reflect.entity.Book;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 本类功能:Method对象
 *
 * @author chenchong
 * @date 2020/12/15 18:46
 */
public class MethodReflect {
    public static void main(String[] args) {
        Book book = new Book();
        book.setId(2);
        book.setName("斗破苍穹");
        book.setType("小说");
//        show(book);
        showUse(book);
    }

    /**
     * 根据传递过来的实体类对象来获得带类对象中的方法信息
     * @param object
     */
    public static void show(Object object){
        Class cl = object.getClass();
        //获取所有的方法
        Method[] declaredMethods = cl.getDeclaredMethods();
        for ( Method m : declaredMethods ) {
            System.out.println("方法名称:"+m.getName());
            System.out.println("方法返回值类型:"+m.getReturnType());
            System.out.println("方法修饰符标号:"+m.getModifiers());
            System.out.println("方法修饰符:"+ Modifier.toString(m.getModifiers()));
            System.out.println("方法的注解信息:");
            Annotation[] declaredAnnotations = m.getDeclaredAnnotations();
            for ( Annotation a : declaredAnnotations) {
                System.out.println(a.toString());
            }

            System.out.println("方法的参数列表:");
            Class<?>[] parameterTypes = m.getParameterTypes();
            for ( Class cll : parameterTypes) {
                System.out.println(cll.getSimpleName());

            }
            System.out.println("==========================");
        }
    }

    /**
     * 使用传递过来的实体类获取其中的方法并调用
     * @param object
     */
    public static void showUse(Object object){
        //获取Class对象
        Class cl = object.getClass();

        try {
            //获取指定的方法,传入方法名和方法参数,方法参数为Class数组
            Method setName = cl.getMethod("setName", String.class);
            //第一个参数为执行该方法的对象,第二个方法为Object数组
            setName.invoke(object,"鲁冰逊漂流记");

            Method getName = cl.getMethod("getName", null);
            getName.invoke(object,new Object[0]);

            Method test = cl.getMethod("test", new Class[]{String.class, String.class});
            test.invoke(object,new Object[]{"陈","冲"});



        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

}
