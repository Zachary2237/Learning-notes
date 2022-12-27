package Chapter15.Part2.test;

/**
 * @author wxh
 * @create 2022-12-27 10:40
 */

@MyAnnotation(value = "hi")
public class Person1 extends Creature<String> implements Comparable<String>, MyInterface {

    private String name;
    int age;
    public int id;

    public Person1() {}

    @MyAnnotation(value = "abc")
    private Person1(String name) {
        this.name = name;
    }


    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("Nation = " + nation);
        return nation;
    }

    public String display(String interest, int age) throws NullPointerException, ClassNotFoundException {
        return interest + age;
    }

    @Override
    public void info () {
        System.out.println("I'm a man!");
    }

    @Override
    public int compareTo (String o) {
        return 0;
    }

    private static void showDesc() {
        System.out.println("I'm a static Method");
    }

    @Override
    public String toString () {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                "} " + super.toString();
    }
}
