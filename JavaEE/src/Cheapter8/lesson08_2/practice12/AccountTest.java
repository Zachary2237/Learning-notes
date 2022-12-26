package Cheapter8.lesson08_2.practice12;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxh
 * @description
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 * 问题：该程序是否有安全问题，如果有，如何解决？
 * @create 2022-10-22 10:04
 */

class Account implements Runnable{

    private static int money;

    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run(){
        try{
            lock.lock();

            int count = 3;
            while(count > 0){
                money += 1000;

                try{
                    Thread.sleep(200);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + ": " + money);

                count--;
            }
        }finally{
            lock.unlock();
        }

    }
}

public class AccountTest{
    public static void main(String[] args){

        Account account = new Account();

        Thread t1 = new Thread(account);
        Thread t2 = new Thread(account);

        t1.setName("储户1");
        t2.setName("储户2");

        t1.start();
        t2.start();

    }
}
