package lesson08_2_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wxh
 * @description
 *
 * 创建线程的方式三: 实现Callable接口 ----JDK 5.0新增
 *
 * 1. 创建一个实现Callable接口的实现类
 * 2. 实现call()方法, 将此线程需要执行的操作声明在call()中
 * 3. 创建Callable接口实现类的对象
 * 4. 将此实现类的对象作为参数传递到FutureTask构造器中, 创建FutureTask的对象
 * 5. 将FutureTask的对象作为参数传递到Thread类的构造器中, 创建Thread对象, 并调用start()
 * 6. (可选)湖片区Callable中call方法的返回值
 *
 * 如何理解实现Callable接口的方式创建多线程比Runnable接口创建多线程的方式更强大
 *
 * 1. call()可以有返回值
 * 2. call()可以抛出异常, 被外面的操作捕获, 获取异常的信息
 * 3. Callable支持泛型
 *
 * @create 2022-10-22 14:17
 */

class NumThread implements Callable{

    @Override
    public Object call() throws Exception{
        int sum = 0;
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 0){
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew{
    public static void main(String[] args){

        NumThread numThread = new NumThread();

        FutureTask futureTask = new FutureTask(numThread);

        new Thread(futureTask).start();

        try{
            Object obj = futureTask.get();
            System.out.println(obj);
        } catch(InterruptedException e){
            e.printStackTrace();
        } catch(ExecutionException e){
            e.printStackTrace();
        }

    }
}
