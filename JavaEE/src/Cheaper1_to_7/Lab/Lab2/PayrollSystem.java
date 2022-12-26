package Cheaper1_to_7.Lab.Lab2;

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
            //方式一
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入当月月份: ");
//        int month = scanner.nextInt();

        //方式二
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);

        Employee emps[] = new Employee[2];

        emps[0] = new SalariedEmployee("mason", 1002, new MyDate(1992, 2, 28), 3900);
        emps[1] = new HourlyEmployee("pannel", 2001, new MyDate(2002, 10, 18), 20, 9);

        for(int i = 0; i < emps.length; i ++ ){
            System.out.println(emps[i]);
            double salary = emps[i].earnings();
            System.out.println("salary = " + salary);

            if(month+1 == emps[i].getBirthday().getMonth()){
                System.out.println("生日快乐,奖励100元");
            }
        }
    }
}
