package TeamScheduleProject.view;

import TeamScheduleProject.domain.*;
import TeamScheduleProject.service.NameListService;
import TeamScheduleProject.service.TeamService;
import org.junit.Test;

import java.lang.invoke.CallSite;
import java.util.Arrays;

import static TeamScheduleProject.service.Data.*;
import static TeamScheduleProject.view.TSUtility.*;

/**
 * @author wxh
 * @create 2022-12-28 17:43
 */
public class TeamView {

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    @Test
    public void enterMainMenu() {
        System.out.println("-------------------------------开发团队调度软件--------------------------");
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        listAllEmployees();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1-团队列表\t2-添加团队成员\t3-删除团队成员\t4-退出\t请选择(1-4): ");

        char c = readMenuSelection();
        switch (c) {
            case '1' -> {
                getTeam();
            }

            case '2' -> {

            }

            case '3' -> {

            }

            case '4' -> {

            }
        }
    }

    private void listAllEmployees() {
        Employee[] employees = listSvc.getAllEmployees();
//        for (Employee e : employees) {
//            int id = e.getId();
//            String name = e.getName();
//            int age = e.getAge();
//            double salary = e.getSalary();
//            String type = listSvc.getType(e);
//            String status = listSvc.getStatus(e);
//            Double bonus = null;
//            Integer stock = null;
//            if (type != null && type.equalsIgnoreCase("架构师")) {
//                Architect a = (Architect) e;
//                stock = a.getStock();
//                bonus = a.getBonus();
//            } else if (type != null && type.equalsIgnoreCase("设计师")) {
//                Designer d = (Designer) e;
//                bonus = d.getBonus();
//            }
//
//            System.out.println(id + "\t" + name + "\t" + age + "\t" + salary + "\t" +
//                    type + "\t" + status + "\t" + bonus + "\t" + stock + "\t");
//        }
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    private void getTeam() {
        System.out.println("-----------------团队成员列表-------------");
        Programmer[] team = teamSvc.getTeam();
        if (team.length == 0) {
            System.out.println("开发团队没有成员");
        } else {
            System.out.println("TID");
        }
    }

    private void addMember() {

    }

    private void deleteMember() {

    }

    public static void main (String[] args) {

        TeamView teamView = new TeamView();
        teamView.listAllEmployees();

    }

}
