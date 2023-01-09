package TeamScheduleProject.domain;

/**
 * @author wxh
 * @create 2022-12-27 19:36
 */
public class PC implements Equipment {

    private String model;
    private String display;

    public PC () {
    }

    public PC (String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel () {
        return model;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public String getDisplay () {
        return display;
    }

    public void setDisplay (String display) {
        this.display = display;
    }

    @Override
    public String getDescription () {
        String str = "{" + model + "\t" + display + "}";
        return str;
    }
}
