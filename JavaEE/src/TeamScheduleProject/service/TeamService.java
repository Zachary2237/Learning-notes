package TeamScheduleProject.service;

import TeamScheduleProject.domain.Architect;
import TeamScheduleProject.domain.Designer;
import TeamScheduleProject.domain.Employee;
import TeamScheduleProject.domain.Programmer;
import org.junit.TestCouldNotBeSkippedException;

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * @author wxh
 * @create 2022-12-27 20:14
 */
public class TeamService {

    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (total >= 5) {
            throw new TeamException("成员已满,无法添加");
        } else if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员,无法添加");
        } else {
            Programmer p = (Programmer) e;

            if (isExist(p)) {
                throw new TeamException("该成员已在开发团队中,添加失败");
            } else if (p.getStatus() == Status.BUSY) {
                throw new TeamException("该成员已是某团队成员");
            } else if (p.getStatus() == Status.FREE) {
                throw new TeamException("该员工正在休假,无法添加");
            } else {
                int[] num = getNum();

                int numArchitect = num[0];
                int numDesigner = num[1];
                int numProgrammer = num[2];

                if (p instanceof Architect) {
                    if (numArchitect >= 1) {
                        throw new TeamException("团队中最多仅能有一名架构师");
                    } else {
                        total++;
                        team[total] = p;
                        p.setMemberId(counter);
                        counter++;
                        p.setStatus(Status.BUSY);
                    }
                } else if (p instanceof Designer) {
                    if (numDesigner >= 2) {
                        throw new TeamException("团队中最多仅能有两名设计师");
                    } else {
                        total++;
                        team[total] = p;
                        p.setMemberId(counter);
                        counter++;
                        p.setStatus(Status.BUSY);
                    }
                } else {
                    if (numProgrammer >= 3) {
                        throw new TeamException("团队中最多仅能有三名程序员");
                    } else {
                        total++;
                        team[total] = p;
                        p.setMemberId(counter);
                        counter++;
                        p.setStatus(Status.BUSY);
                    }
                }


            }
        }

    }

    private int[] getNum () {

        int numArchitect = 0;
        int numDesigner = 0;
        int numProgrammer = 0;

        for (Programmer p : team) {
            if (p instanceof Architect) {
                numArchitect++;
            } else if (p instanceof Designer) {
                numDesigner++;
            } else {
                numProgrammer++;
            }
        }

        return new int[] {numArchitect, numDesigner, numProgrammer};

    }

    private boolean isExist (Programmer p) {
        for (Programmer pro : this.team) {
            if (pro == p) {
                return true;
            }
        }

        return false;
    }

    public void removeMember(int memberId) throws TeamException {

        for (int i = 0; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                for (int j = i; j < total - 1; j++) {
                    team[j] = team[j + 1];
                }
                return;
            }
        }

        throw new TeamException("未找到该成员");

    }

}
