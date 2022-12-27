package Chapter8.lesson08_2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxh
 * @description 方式三: Lock锁 ---JDK5.0新增,见LockTest
 * @create 2022-10-22 9:47
 */

class Window implements Runnable{

    private int ticket = 100;

    //实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run(){
        while(true){
            try{
                //调用lock()方法
                lock.lock();

                if(ticket > 0){
                    try{
                        Thread.sleep(100);
                    } catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + ": 票号为: " + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally{
                //调用解锁方法unlock()
                lock.unlock();
            }

        }
    }
}

public class LockTest{
    public static void main(String[] args){

        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("Window1");
        t2.setName("Window2");
        t3.setName("Window3");

        t1.start();
        t2.start();
        t3.start();

    }
}
