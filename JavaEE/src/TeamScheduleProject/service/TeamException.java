package TeamScheduleProject.service;

/**
 * @author wxh
 * @create 2022-12-27 20:07
 */
public class TeamException extends Exception {

    private String message;

    public TeamException (String message) {
        super(message);
        this.message = message;
    }
}
