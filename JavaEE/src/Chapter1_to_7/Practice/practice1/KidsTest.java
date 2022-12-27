package Chapter1_to_7.Practice.practice1;

public class KidsTest {
    public static void main(String[] args) {
        Kids someKid = new Kids();
        someKid.sex = 1;
        someKid.salary = 1000;
        someKid.yearsOld = 20;
        someKid.printAge();
        someKid.manOrWoman();
        someKid.employeed();
    }
}

class Mankind{
    int sex;
    int salary;

    public Mankind(){}

    void manOrWoman(){
        if(sex == 1){
            System.out.println("Man");
        }
        else if(sex == 0){
            System.out.println("Woman");
        }
    }

    void employeed(){
        if(salary == 0) {
            System.out.println("No job");
        }else{
            System.out.println("Job");
        }
    }
}

class Kids extends Mankind{
    int yearsOld;
    void printAge(){
        System.out.println("Age = " + yearsOld);
    }
}