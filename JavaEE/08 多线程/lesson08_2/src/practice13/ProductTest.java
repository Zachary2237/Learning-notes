package practice13;

/**
 * @author wxh
 * @description 线程通信的应用：生产者消费者问题
 * @create 2022-10-22 10:48
 */

class Clerk{

    private int product;

    public synchronized void addProduct(){

        if(product < 20){
            product++;
            System.out.println(Thread.currentThread().getName() + "生产第" + product + " 个产品");

            notify();
        }else{
            try{
                wait();
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }

    }

    public synchronized void decreaseProduct(){

        if(product > 0){
            System.out.println(Thread.currentThread().getName() + "消费第" + product + " 个产品");
            product--;

            notify();
        }else {
            try{
                wait();
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }


    }
}

class Productor implements Runnable{

    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run(){
        System.out.println("开始生产");
        while(true){
            clerk.addProduct();
        }

    }
}

class Customer implements Runnable{

    private Clerk clerk;

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run(){
        System.out.println("消费者开始消费");
        while(true){
            clerk.decreaseProduct();
        }

    }
}

public class ProductTest{
    public static void main(String[] args){

        Clerk clerk = new Clerk();

        Productor p1 = new Productor(clerk);
        Productor p2 = new Productor(clerk);

        Customer c1 = new Customer(clerk);
        Customer c2 = new Customer(clerk);

        Thread t1 = new Thread(p1);
        t1.setName("生产者1");

//        Thread t2 = new Thread(p2);
//        t2.setName("生产者2");

        Thread t3 = new Thread(c1);
        t3.setName("消费者1");

//        Thread t4 = new Thread(c2);
//        t4.setName("消费者2");

        t1.start();
//        t2.start();
        t3.start();
//        t4.start();


    }
}
