package IO;

import java.io.Serializable;

/**
 * @author wxh
 * @description
 *
 * 若想序列化,需要满足一些要求
 * 1.需要实现接口:Serializable
 * 2.当前类提供一个全局常量: serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外,还必须保证其内部所有属性也是可序列化的
 *   (默认情况下,基本数据类型可序列化)
 * 4.补充:ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 *
 *
 *
 * @create 2022-12-24 18:52
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 42124124124L;

    private String name;
    private int age;

    public Person () {
    }

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
