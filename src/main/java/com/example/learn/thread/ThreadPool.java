package com.example.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 *
 * 创建线程的方式四：使用线程池（批量使用线程）
 *1.需要创建实现runnable或者callable接口方式的对象
 * 2.创建executorservice线程池
 * 3.将创建好的实现了runnable接口类的对象放入executorService对象的execute方法中执行。
 * 4.关闭线程池
 *
 *
 * @author chenchong
 * @date 2020/12/15 14:42
 */
public class ThreadPool {
    public static void main(String[] args) {
        //创建一个固定线程个数为10个的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //new一个Runnable接口的对象
        NumberThread numberThread = new NumberThread();

        NumberThread1 numberThread1 = new NumberThread1();

        //执行线程,最多是十个
        executorService.execute(numberThread);
        executorService.execute(numberThread1);//适合用于Runnable

//        executorService.submit(numberThread);//适合用于Callable
        //关闭线程池
        executorService.shutdown();

    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=100 ; i++) {
            if(i % 2 == 0 ){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 1){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
