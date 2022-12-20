package Collection.Practice;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wxh
 * @description
 * @create 2022-12-20 16:19
 */
public class Practice2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of students: ");
        int num = scanner.nextInt();
        System.out.println("Name and score: ");

        Set set = new TreeSet();
        for(int i = 0; i < num; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            set.add(new Student(name, score));
        }

        Iterator iterator = set.iterator();
        int j = 0;
        while(iterator.hasNext() && j < 3) {
            Object next = iterator.next();
            if(next instanceof Student) {
                Student student = (Student) next;
                System.out.println("name = " + student.getName() + ", score = " + student.getScore());
            }

            j++;
        }
    }

}
