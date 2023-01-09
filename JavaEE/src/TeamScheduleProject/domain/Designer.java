package TeamScheduleProject.domain;

/**
 * @author wxh
 * @create 2022-12-27 19:37
 */
public class Designer extends Programmer {

    private double bonus;

    public Designer () {
    }

    public Designer (int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus () {
        return bonus;
    }

    public void setBonus (double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString () {
        return super.toString() + bonus + "\t";
    }
}
