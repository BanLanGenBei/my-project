package com.example.learn.thread;

/**
 * 本类功能:synchronize修饰对象 - 对象锁
 *
 * @author chenchong
 * @date 2020/12/15 15:26
 */
@SuppressWarnings("all")
public class ObjectLock {
    public static void main(String[] args) {
        Account account = new Account("张三",200);
        AccountOperator accountOperator = new AccountOperator(account);
        Thread t1 = new Thread(accountOperator,"线程一");
        Thread t2 = new Thread(accountOperator,"线程二");
        Thread t3 = new Thread(accountOperator,"线程三");
        Thread t4 = new Thread(accountOperator,"线程四");
        Thread t5 = new Thread(accountOperator,"线程五");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }
}

/**
 * 用户账户
 */
class Account{
    //账户姓名
    String name;
    //账户的金额
    float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    //存钱
    public void deposit(float amt){
        amount = amount + amt;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //取钱
    public void withdraw(float amt){
        amount = amount - amt;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //获取余额
    public float getBalance(){
        return amount;
    }
}

/**
 * 账户操作类
 */
class AccountOperator implements Runnable{

    private Account account;

    public AccountOperator(Account account) {
        this.account = account;
    }

    @Override
    public void run() {

        synchronized (account){
            account.withdraw(100);

            account.withdraw(100);
            System.out.println(Thread.currentThread().getName()+":"+account.getBalance());
        }



    }
}