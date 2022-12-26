package Cheaper11.Map.java;

import java.util.Objects;

/**
 * @author wxh
 * @description
 * @create 2022-12-15 17:27
 */
public class User implements Comparable{

    private String name;
    private int age;

    public User(){
    }

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && name.equals(user.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o){
        if(o instanceof User){
            User u = (User) o;
//            return this.name.compareTo(u.name);
            int compare = this.name.compareTo(u.name);
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age, u.age);
            }
        }else{
            throw new RuntimeException("error");
        }
    }
}
