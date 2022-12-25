package Source.Template;

public class TemplateTest {
    public static void main(String[] args) {

        SubTemplate t = new SubTemplate();
        t.spendTime();

    }
}

abstract class Template{

    //计算某段代码执行所花费的时间
    public void spendTime(){

        long start = System.currentTimeMillis();

        code();

        long end = System.currentTimeMillis();

        System.out.println("Time = " + (end - start));

    }

    public abstract void code();

}

class SubTemplate extends Template{

    @Override
    public void code() {

        for(int i = 2; i <= 1000; i ++ ){
            boolean isFlag = true;
            for(int j = 2; j <= Math.sqrt(i); j ++ ){

                if(i % j == 0){
                    isFlag = false;
                    break;
                }

            }
            if(isFlag){
                System.out.println(i);
            }
        }

    }
}
