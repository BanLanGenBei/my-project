package com.example.learn.thread;


/**
 * 1.创建一个集成于Thread类的子类 （通过ctrl+o（override）输入run查找run方法）
 * 2.重写Thread类的run（）方法
 * 3.创建Thread子类的对象
 * 4.通过此对象调用start（）方法
 *
 * 创建三个窗口买票,总票数是100张,使用继承自Thread方式
 * 用静态变量保证三个线程的数据独一份
 *
 * 但是存在着线程安全的问题,有待解决
 *
 *
 * @author chenchong
 * @date 2020/12/15 13:13
 */
public class ThreadDemo extends Thread{
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("售票口1");
        t2.setName("售票口2");
        t3.setName("售票口3");

        t1.start();
        t2.start();
        t3.start();

    }

}

class Window extends Thread {
    //将票数加载在类的静态区,所有的线程共享该静态的变量
    private static int ticket = 100;

    @Override
    public  void run(){
        while(true){
            if(ticket>0){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName()+"当前售出第"+ticket+"张票");
                ticket--;

            }else{
                break;
            }
        }
    }

}