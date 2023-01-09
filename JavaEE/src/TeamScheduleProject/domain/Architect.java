package TeamScheduleProject.domain;

/**
 * @author wxh
 * @create 2022-12-27 19:37
 */
public class Architect extends Designer {

    private int stock;

    public Architect () {
    }

    public Architect (int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock () {
        return stock;
    }

    public void setStock (int stock) {
        this.stock = stock;
    }

    @Override
    public String toString () {
        return super.toString() + stock + "\t";
    }
}
