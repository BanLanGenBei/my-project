package com.example.learn.proxy.statics;

/**
 * 本类功能:
 * 一个代理类,代理类实现了接口类,并且"爱管闲事",调用了实现了接口类的实体类的方法
 *
 * 代理类的工作就是把实体类接过来,然后调用他的方法,也就是说本来实体类是可以自己执行
 * 的方法现在由代理类来触发执行,这样做的好处是,在调用实体类方法的前后,我们可以插入
 * 监控方法
 *
 * @author chenchong
 * @date 2020/12/17 19:45
 */
public class StudentProxy implements Person{
    Student student = new Student();
    @Override
    public void giveMoney() {
        System.out.println("这位同学最近学习有进步!");
        student.giveMoney();
    }
    public StudentProxy(Person student){
        if(student.getClass() == Student.class){
            this.student = (Student) student;
        }
    }

}
