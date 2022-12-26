package Cheaper12.Lab.lab1;

import Cheaper12.Lab.lab1.Employee;
import Cheaper12.Lab.lab1.MyDate;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author wxh
 * @description
 * @create 2022-12-22 9:51
 */
public class EmployeeTest {

    @Test
    public void test1() {
        Employee e1 = new Employee("Tom", 18, new MyDate(12, 11, 2003));
        Employee e2 = new Employee("Jack", 22, new MyDate(8, 30, 2001));
        Employee e3 = new Employee("Harry", 27, new MyDate(4, 10, 2002));
        Employee e4 = new Employee("Marry", 20, new MyDate(6, 19, 1999));
        Employee e5 = new Employee("Rose", 24, new MyDate(5, 18,2000));

        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    @Test
    public void test2() {
        Employee e1 = new Employee("Tom", 18, new MyDate(12, 11, 2003));
        Employee e2 = new Employee("Jack", 22, new MyDate(8, 30, 2002));
        Employee e3 = new Employee("Harry", 27, new MyDate(4, 10, 2002));
        Employee e4 = new Employee("Marry", 20, new MyDate(6, 19, 1999));
        Employee e5 = new Employee("Rose", 24, new MyDate(5, 18,2000));

        TreeSet<Employee> employees = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare (Employee o1, Employee o2) {
                if (o1.getBirthday().getYear() != o2.getBirthday().getYear()) {
                    return Integer.compare(o1.getBirthday().getYear(), o2.getBirthday().getYear());

                } else if (o1.getBirthday().getMonth() != o2.getBirthday().getMonth()) {
                    return Integer.compare(o1.getBirthday().getMonth(), o2.getBirthday().getMonth());
                } else {
                    return Integer.compare(o1.getBirthday().getDay(), o2.getBirthday().getDay());
                }
            }
        });
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        for (Employee e : employees) {
            System.out.println(e);
        }
    }

}
