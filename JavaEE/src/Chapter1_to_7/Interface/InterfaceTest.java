package Chapter1_to_7.Interface;

public class InterfaceTest {
}

interface Flyable{
    //全局常量
    public static final int MAX_SPEED = 7900;
    public static final int MIN_SPEED = 1;

    //抽象方法
    public abstract void fly();

    public abstract void stop();

}

interface Attackable{

    void attack();

}

class Plane implements Flyable{


    @Override
    public void fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}

abstract class Kite implements Flyable{


}

class Bullet implements Flyable, Attackable{


    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }
}

//********************************************

interface AA{
    void method1();
}

interface BB{
    void method2();
}

interface CC extends AA, BB{

}
