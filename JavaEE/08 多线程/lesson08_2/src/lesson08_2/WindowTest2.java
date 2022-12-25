package lesson08_2;

/**
 * @author wxh
 * @description
 *
 * eg:
 *
 * 说明: 在继承Thread类创建多线程的方式中, 慎用this来充当同步监视器, 可以考虑使用当前类来充当同步监视器
 *
 * @create 2022-10-17 14:25
 */

class Window2 extends Thread{

    private static int ticket = 100;

    static Object obj = new Object();

    @Override
    public void run() {

        while (true){
            synchronized(Window2.class){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + ": 卖票, 票号为: " + ticket);
                    ticket--;
                }else {
                    break;
                }
            }

        }

    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}