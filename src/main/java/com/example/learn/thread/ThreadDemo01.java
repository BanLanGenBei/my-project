package com.example.learn.thread;



/**
 * 本类功能:
 * 1.创建一个实现了Runable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类中的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start（）
 *
 * @author chenchong
 * @date 2020/12/15 14:09
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        //这里虽然只有一个窗口类实现了Runnable方法
        //由于三个线程是共用一个window对象,所以自动
        //共用100张票
        Window1 window1 = new Window1();
        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);
        //设置线程的名字
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        //启动线程
        t1.start();
        t2.start();
        t3.start();


    }
}

class Window1 implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        synchronized (this){
            while(true){
                if(ticket>0){
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //获取当前的线程的名字
                    System.out.println(Thread.currentThread().getName()+"当前售出第"+ticket+"张票!");
                    ticket--;
                }else {
                    break;

                }
            }
        }
    }
}
