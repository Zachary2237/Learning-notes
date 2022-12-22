package Generic.Lab.lab1;

/**
 * @author wxh
 * @description
 * @create 2022-12-22 9:47
 */
public class Employee implements Comparable{

    private String name;
    private int age;
    private MyDate birthday;

    public Employee () {
    }

    public Employee (String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public MyDate getBirthday () {
        return birthday;
    }

    public void setBirthday (MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString () {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo (Object o) {
        if (o instanceof Employee) {
            Employee emp = (Employee) o;
            return this.name.compareTo(emp.name);
        } else {
            throw new RuntimeException("Error");
        }
    }
}
