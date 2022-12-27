package Chapter1_to_7.Practice.practice6;

import java.util.Scanner;
import java.util.Vector;

public class WrapperTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector v = new Vector();
        int maxScore = 0;
        for(;;){
            System.out.println("请输入学生成绩");
            int score = scanner.nextInt();
            if(score < 0){
                break;
            }
            if(score > 100){
                System.out.println("输入的数据非法,请重新输入");
                continue;
            }
            v.addElement(score);
            if(maxScore < score){
                maxScore = score;
            }
        }

        int temp = 0;
        char level;
        for(int i = 0; i < v.size(); i ++ ){
            temp = (int) v.elementAt(i);

            if(maxScore - temp <= 10){
                level = 'A';
            }else if(maxScore - temp <= 20){
                level = 'B';
            } else if (maxScore - temp <= 30) {
                level = 'C';
            }else {
                level = 'D';
            }

            System.out.println("student-" + i + " score is " + temp + " level is " + level);
        }


    }
}
