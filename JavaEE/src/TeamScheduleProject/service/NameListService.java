package TeamScheduleProject.service;

import TeamScheduleProject.domain.*;
import org.junit.Test;

import java.util.Arrays;

import static TeamScheduleProject.service.Data.EMPLOYEES;
import static TeamScheduleProject.service.Data.EQUIPMENTS;

/**
 * @author wxh
 * @create 2022-12-27 19:59
 */
public class NameListService {

    private Employee[] employees;

    public NameListService () {

        this.employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            int salary = Integer.parseInt(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;

            switch (type) {
                case 10:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case 11:
                    equipment = getEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case 12:
                    bonus = Integer.parseInt(EMPLOYEES[i][5]);
                    equipment = getEquipment(i);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case 13:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);
                    equipment = getEquipment(i);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }

        }

    }

    private Equipment getEquipment(int i) {

        int type = Integer.parseInt(EQUIPMENTS[i][0]);
        Equipment equipment = null;
        String model;
        String display;
        double price;
        switch (type) {
            case 21 -> {
                model = EQUIPMENTS[i][1];
                display = EQUIPMENTS[i][2];
                equipment = new PC(model, display);
            }
            case 22 -> {
                model = EQUIPMENTS[i][1];
                price = Double.parseDouble(EQUIPMENTS[i][2]);
                equipment = new NoteBook(model, price);
            }
            case 23 -> {
                model = EQUIPMENTS[i][1];
                display = EQUIPMENTS[i][2];
                equipment = new Printer(model, display);
            }
        }

        return equipment;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }

        throw new TeamException("找不到指定的员工!");
    }

    public String getType(Employee e) {
        if (e instanceof Architect) {
            return "架构师";
        } else if (e instanceof Designer) {
            return "设计师";
        } else if (e instanceof Programmer) {
            return "程序员";
        } else
            return null;
    }

    public String getStatus(Employee e) {
        String str = "";
        if (e instanceof Programmer) {
            Programmer p = (Programmer) e;
            str = p.getStatus().toString();
        }

        return str;
    }

    @Test
    public void test() throws TeamException {

        NameListService n1 = new NameListService();
        System.out.println(Arrays.toString(n1.getAllEmployees()));
        System.out.println(n1.getEmployee(4));

    }

    @Override
    public String toString () {
        return "NameListService{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }
}
