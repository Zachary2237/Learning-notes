package Cheaper1_to_7.practice2;

class Person{
    protected String name = "person";
    protected int age = 50;
    public String getInfo(){
        return "Name: " + name + "\n" + "age: " + age;
    }

}

class Student extends Person{
    protected String school = "pku";
    public String getInfo(){
        return "Name: " + name + "\nage" + age + "\nschool: " + school;
    }
}

class Graduate extends Student{
    public String major = "IT";
    public String getInfo(){
        return "Name: " + name + "\nage" + age + "\nschool: " + school + "\nmajor" + major;
    }
}

public class InstanceTest {
    public void method(Person e){
        String info = e.getInfo();
        System.out.println(info);

        if(e instanceof  Graduate){
            System.out.println("a graduated student");
        }
        if(e instanceof Student){
            System.out.println("a student");
        }
        if(e instanceof Person){
            System.out.println("a person");
        }
    }

    public static void main(String[] args) {
        InstanceTest test = new InstanceTest();
        test.method(new Graduate());
        //method(new Person());
        //method(new Student());

    }
}
