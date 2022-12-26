package Cheaper1_to_8.Singleton;

public class SingletonTest1 {
    public static void main(String[] args) {



    }
}
//饿汉式
class Bank{
    //1.私有化类的构造器
    private Bank(){

    }
    //2.内部创建类的对象
    //4.要求此对象也必须声明为static的
    private static Bank instance = new Bank();

    //3.提供公共的方法,返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}
