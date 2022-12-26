package Cheaper1_to_7.Practice.practice9;

public class EmployeeTest {
    public static void main(String[] args) {

        Employee manager = new Manager("kook", 1001, 5000, 50000);
        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }
}
