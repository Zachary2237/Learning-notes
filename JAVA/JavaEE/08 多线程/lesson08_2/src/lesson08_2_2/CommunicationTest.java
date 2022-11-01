package lesson08_2_2;

/**
 * @author wxh
 * @description
 *
 * 线程通信的例子: 使用两个线程打印1-100, 交替打印
 *
 * 三个方法:
 * wait(): 一旦执行此方法, 当前线程就进入阻塞状态, 并释放同步监视器
 * notify(): 一旦执行此方法, 就会唤醒被wait的一个线程, 如果有多个线程被wait, 就唤醒优先级高的哪个
 * notifyAll(): 一旦执行此方法, 就会唤醒所有被wait的线程
 *
 * 说明:
 * 1. wait(), notify(), notifyAll() 三个方法必须使用在同步代码块或同步方法中
 * 2. wait(), notify(), notifyAll() 三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 *      否则会出现异常
 * 3. wait(), notify(), notifyAll() 三个方法是定义在Object类中的
 *
 * 面试题: sleep() 和 wait() 的异同?
 * > 相同点: 一旦执行方法, 都可以使得当前的线程进入阻塞状态
 * > 不同点:
 *      - 两个方法声明的位置不同, Thread类中声明sleep(), Object类中声明wait()
 *      - 调用的要求不同, sleep()可以在任何需要的场景下调用, wait() 必须使用在同步代码块或同步方法中
 *      - 关于是否释放同步监视器: 如果两个方法都使用在同步代码块或同步方法中, sleep()方法不会释放锁, 而wait()会释放锁
 *
 *
 * @create 2022-10-22 10:21
 */

class Number implements Runnable{

    private static int i = 1;

    @Override
    public void run(){
        while(i <= 100){
            synchronized(this){

                notify();

                System.out.println(Thread.currentThread().getName() + ": " + i);
                i++;

                try{
                    wait();//使得调用如下wait()方法的线程进入阻塞状态
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

public class CommunicationTest{
    public static void main(String[] args){

        Number num = new Number();

        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
