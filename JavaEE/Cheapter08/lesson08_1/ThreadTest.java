package Cheapter08.lesson08_1;

/**
 * @author wxh
 * @Description
 *
 * 多线程的创建:方式一:继承于Thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类中的run()方法 ---> 将此线程执行的操作声明在run()中
 * 3. 创建Thread类的子类的对象
 * 4. 通过此对象调用start()方法 1) 启动当前线程 2) 调用当前线程的run()
 *
 * eg:遍历100以内所有的偶数
 *
 * @create 2022-10-16 10:28
 */

//1. 创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2. 重写Thread类中的run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建Thread类的子类的对象
        MyThread t1 = new MyThread();
//        4. 通过此对象调用start()方法: 1) 启动当前线程 2) 调用当前线程的run()
        t1.start();
//        如下操作仍然哦是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i + "********");
            }
        }
    }
}
