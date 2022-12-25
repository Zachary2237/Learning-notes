package lesson08_2;

/**
 * @author wxh
 * @description 创建三个窗口卖票, 总票数为100张,使用实现Runnable接口的方式
 *
 * 1. 问题: 卖票过程中出现了重票和错票 ----> 线程的安全问题
 * 2. 问题出现的原因: 当某个线程来操作车票的过程中,尚未操作完成时,其他线程参与进来,也操作车票
 * 3. 如何解决: 当一个线程在操作ticket的时候,其他线程不能参与进来,直到线程a操作完ticket的时候,
 *              其他线程才可以开始操作ticket, 即使线程a出现了阻塞,也不能被改变
 * 4. 在Java中,我们通过同步机制来解决线程的安全问题
 *      方式一: 同步代码块
 *
 *          synchronized(同步监视器){
 *              //需要被同步的代码
 *          }
 *
 *      说明: 1. 操作共享数据的代码, 即为需要被同步的代码 ---> 不能包含代码多了, 也不能少了
 *            2. 共享数据: 多个线程共同操作的变量, 如: ticket
 *            3. 同步监视器: 锁. 任何一个类的对象, 都可以充当锁
 *                  要求: 多个线程必须公用同一把锁
 *
 *            补充: 在实现Runnable接口创建多线程的方式中, 我们可以考虑使用this充当同步监视器
 *                  在继承Thread类创建多线程的方式中, 慎用this来充当同步监视器, 可以考虑使用当前类来充当同步监视器
 *
 *      方式二: 同步方法
 *          如果操作共享数据的代码完整的声明在一个方法中, 我们不妨将此方法声明为同步的
 *          总结: 1) 同步方法仍然涉及到同步监视器, 只是不需要显式声明
 *                2) 非静态的同步方法, 同步监视器是: this
 *                   静态的同步方法, 同步监视器是: 当前类本身
 *
 *      方式三: Lock锁 ---JDK5.0新增,见LockTest
 *
 *      优先使用顺序：
 *      Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 *
 *       > 面试题: synchronized与lock的异同
 *          - 都可以解决线程的安全问题
 *          - synchronized机制在执行完相应的同步代码之后, 自动释放同步监视器
 *            Lock需要手动的启动同步, 同时结束同步也需要手动实现(unlock()
 *
 *       > 面试题: 如何解决线程安全问题? 有几种方式?
 *
 * 5. 同步的方式: 解决了线程的安全问题 ---好处
 *    操作同步代码时, 只能有一个线程参与, 其他线程等待, 相当于时一个单线程的过程(效率较低) ---局限性
 *
 * @create 2022-10-17 10:46
 */

class Window1 implements Runnable{

    private int ticket = 100;//可以不用加static
    Object obj = new Object();

    @Override
    public void run(){
        while(true){
            synchronized(this){//此时可以用this, 代表唯一的Window1的对象
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + ": 卖票: 票号: " + ticket);
                    ticket--;
                }else {
                    break;
                }
            }

        }
    }
}

public class WindowTest1{
    public static void main(String[] args){

        Window1 w1 = new Window1();

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
