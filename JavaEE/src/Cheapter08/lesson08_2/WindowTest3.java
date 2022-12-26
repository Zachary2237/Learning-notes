package Cheapter08.lesson08_2;

/**
 * @author wxh
 * @description 使用同步方法解决实现Runnable接口的线程安全问题
 * @create 2022-10-17 14:42
 */

class Window3 implements Runnable{

    private int ticket = 100;//可以不用加static

    @Override
    public void run(){
        while(true){
            show();
        }
    }

    private synchronized void show(){//同步监视器: this

        if(ticket > 0){
            try{
                Thread.sleep(100);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票: 票号: " + ticket);
            ticket--;
        }

    }
}

public class WindowTest3{
    public static void main(String[] args){

        Window3 w1 = new Window3();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
