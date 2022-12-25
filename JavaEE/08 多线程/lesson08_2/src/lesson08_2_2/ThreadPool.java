package lesson08_2_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wxh
 * @description
 *
 * 创建线程的方式四: 使用线程池
 * 1. 提供指定线程数量的线程池
 * 2. 执行指定的线程的操作, 需要提供实现Runnable接口或Callable接口实现类的对象
 *
 * 面试题: 创建多线程有几种方式? ---四种
 *
 * @create 2022-10-22 14:39
 */

class NumberThread implements Runnable{

    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

public class ThreadPool{
    public static void main(String[] args){

        ExecutorService service = Executors.newFixedThreadPool(10);



        service.execute(new NumberThread());//适用于Runnable
        //service.submit();//适用于Callable

        service.shutdown();

    }
}
