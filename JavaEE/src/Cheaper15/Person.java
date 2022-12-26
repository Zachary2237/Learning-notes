package Cheaper15;

/**
 * @author wxh
 * @create 2022-12-26 13:54
 */
public class Person {

    private String name;
    public int age;

    public Person () {
    }

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public void show() {
        System.out.println("Hello!");
    }

    public String showNation(String nation) {
        System.out.println("Nation: " + nation);
        return nation;
    }

    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
