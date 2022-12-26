package Cheapter8.lesson08_1.practice11;

/**
 * @author wxh
 * @Description 练习:两个分线程,其中一个线程输出1-100之间的偶数，另一个线程输出1-100之间的奇数。
 * @create 2022-10-16 10:49
 */

class MyThread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }

        }
    }
}

class MyThread2 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1){
                System.out.println(i);
            }

        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start();
        myThread2.start();

//        创建Thread类的匿名子类
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    if (i % 2 == 1){
//                        System.out.println(Thread.currentThread().getName() + ":" + i);
//                    }
//
//                }
//            }
//        }.start();
    }
}
