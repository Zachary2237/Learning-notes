package Service;

import Domain.Architect;
import Domain.Designer;
import Domain.Employee;
import Domain.Programmer;

public class TeamService {

    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public TeamService() {
    }

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i = 0; i < total; i ++ ){
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException{
        //成员已满,无法添加
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满,无法添加");
        }
        //该成员不是开发人员
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发成员,无法添加");
        }
        Programmer p = (Programmer) e;

        //该成员已在本开发团队中
        if(isExist(p)){
            throw new TeamException("该成员已在本开发团队中,无法添加");
        }
        //该团队已是某团队成员 or 该成员正在休假

        //if(p.getStatus().getNAME().equals("BUSY")){ }
        if("BUSY".equals(p.getStatus().getNAME())){
            throw new TeamException("该团队已是某团队成员");
        }else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("该成员正在休假");
        }
        //团队中至多有一名架构师
        //团队中至多有两名设计师
        //团队中至多有三名程序员

        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for(int i = 0; i < total; i ++ ){
            if(team[i] instanceof Architect){
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }

        if(p instanceof Architect){
            if(numOfArch >= 1){
                throw new TeamException("团队中至多有一名架构师");
            } else if (p instanceof Designer) {
                if(numOfDes >= 2){
                    throw new TeamException("团队中至多有两名设计师");
                }
            } else if (p instanceof Programmer) {
                if(numOfPro >= 3){
                    throw new TeamException("团队中至多有三名程序员");
                }
            }
        }

        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++] = p;

    }

    private boolean isExist(Programmer p) {
        for(int i = 0; i < total; i ++ ){
            if(team[i].getId() == p.getId()){
                return true;
            }
        }

        return false;
    }

    public void removeMember (int memberId) throws TeamException{
        int i = 0;
        for( ; i < total; i ++ ){
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        //未找到
        if(i == total){
            throw new TeamException("找不到指定memberId的员工,删除失败");
        }

        for(int j = i + 1; j < total; j ++ ){
            team[j - 1] = team[j];
        }
        team[--total] = null;

    }

}
