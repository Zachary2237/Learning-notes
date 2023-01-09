package TeamScheduleProject.domain;

/**
 * @author wxh
 * @create 2022-12-27 19:36
 */
public class NoteBook implements Equipment {

    private String model;
    private double price;

    public NoteBook () {
    }

    public NoteBook (String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel () {
        return model;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    @Override
    public String getDescription () {
        String str = "{" + model + "\t" + price + "}";
        return str;
    }
}
