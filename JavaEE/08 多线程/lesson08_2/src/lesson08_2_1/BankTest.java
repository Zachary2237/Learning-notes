package lesson08_2_1;

/**
 * @author wxh
 * @description 单例设计模式懒汉式
 * @create 2022-10-17 15:59
 */

class Bank{

    private Bank(){}

    private static Bank instance = null;

    public static Bank getInstance(){
        //方式一: 效率较低
//        synchronized(Bank.class){
//            if(instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

        //方式二: 效率较高
        if(instance == null){
            synchronized(Bank.class){
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}

public class BankTest{
}
