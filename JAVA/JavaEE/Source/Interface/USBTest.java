package Source.Interface;

public class USBTest {
    public static void main(String[] args) {

        Computer computer = new Computer();
        //1. 创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        computer.transfeiData(flash);

        //2. 创建了接口的非匿名实现类的匿名对象
        computer.transfeiData(new Printer());

        //3. 创建了接口的匿名实现类的非匿名对象
        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("手机开机");
            }

            @Override
            public void stop() {
                System.out.println("手机关机");
            }
        };
        computer.transfeiData(phone);

        //4. 创建了接口的匿名实现类的匿名对象
        computer.transfeiData(new USB() {
            @Override
            public void start() {
                System.out.println("MP3开机");
            }

            @Override
            public void stop() {
                System.out.println("MP3关机");
            }
        });

    }
}

class Computer{
    public void transfeiData(USB usb){

        usb.start();
        System.out.println("具体传输的细节");
        usb.stop();

    }
}

interface USB{
    //常量:长,宽,最大最小的传输速率

    void start();

    void stop();

}

class Flash implements USB{


    @Override
    public void start() {
        System.out.println("U盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作");
    }
}

class Printer implements USB{

    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}