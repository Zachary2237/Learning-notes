package Cheaper1_to_7.practice9;

public class Manager extends Employee{

    private double bonus;

    @Override
    public void work() {
        System.out.println("管理员工,提高工作效率");
    }

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }


}
