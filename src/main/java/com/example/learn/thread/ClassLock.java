package com.example.learn.thread;

/**
 * 本类功能:synchronize修饰类 - 类锁
 *
 * @author chenchong
 * @date 2020/12/15 16:44
 */
@SuppressWarnings("all")
public class ClassLock {
    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread t1 = new Thread(syncThread,"线程一");
        Thread t2 = new Thread(syncThread,"线程二");
        Thread t3 = new Thread(syncThread,"线程三");
        Thread t4 = new Thread(syncThread,"线程四");
        Thread t5 = new Thread(syncThread,"线程五");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}

class SyncThread implements Runnable{

    private static int count;

    public SyncThread() {
        count = 0;
    }

    public static void method(){
        //锁住类
        synchronized (SyncThread.class){
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    @Override
    public void run(){
        method();
    }
}
