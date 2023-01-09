package TeamScheduleProject.domain;

import TeamScheduleProject.service.NameListService;
import TeamScheduleProject.service.Status;

import static TeamScheduleProject.service.Status.*;

/**
 * @author wxh
 * @create 2022-12-27 19:37
 */
public class Programmer extends Employee {

    private int memberId;
    private Status status = FREE;
    private Equipment equipment;

    public Programmer () {
    }

    public Programmer (int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId () {
        return memberId;
    }

    public void setMemberId (int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus () {
        return status;
    }

    public void setStatus (Status status) {
        this.status = status;
    }

    public Equipment getEquipment () {
        return equipment;
    }

    public void setEquipment (Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString () {
        String str = this.getId() + "\t" + this.getName() + "\t" + this.getAge() + "\t" + status + "\t" +
                new NameListService().getType(this) + "\t" + this.getSalary() + "\t";
        return str;
    }
}
