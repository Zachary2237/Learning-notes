package Chapter15.Part1;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 通过直接new的方式或反射的方式都可以调用公共的结构,开发中到底用哪个
 * 建议: 直接new的方式
 * 什么时候会使用反射的方式: *反射的特征:动态性
 *
 * 反射机制是否与封装性矛盾?如何看待两个技术
 * ---不矛盾
 *
 *
 * 关于java.lang.Class类的理解
 * 1.类的加载过程:
 * 程序在经过javac.exe命令以后,会生成一个或多个字节码文件(.class结尾),接着,我们使用java.exe命令对某个字节码文件进行解释运行.
 * 相当于将某个字节码文件加载到内存中.此过程称为类的加载.加载到内存中的类,我们称为运行时类,此运行时类,就作为Class类的一个实例
 *
 * 2.换句话说,Class的实例就对应着一个运行时类
 * 3.加载到内存中的运行时类,会缓存一定的时间,在此时间内,我们可以通过不同的方式来获取此运行时类
 *
 * @author wxh
 * @create 2022-12-26 13:54
 */
public class ReflectionTest {

    /**
     * 获取Class实例的方式:(需掌握前三种)
     */
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一:调用运行时类的属性:.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二:通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三:调用Class的静态方法:forName(String classPath)
        Class<?> clazz3 = Class.forName("Chapter15.Part1.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        //方式四:使用类的加载器:ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("Chapter15.Part1.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4);
    }

    //反射之前,对于Person类的操作
    @Test
    public void test1() {

        //1.创建Person类的对象
        Person p1 = new Person("Tom", 18);

        //2.通过调用,调用其内部的属性和方法
        p1.age = 10;

        System.out.println(p1);
        p1.show();

        //在Person类外部,不可以通过Person类的对象调用其内部私有结构
        //如:name,showNation()及私有的构造器

    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Person> personClass = Person.class;
        //1.通过反射,创建Person类的对象
        Constructor<Person> cons = personClass.getConstructor(String.class, int.class);
        Person tom = cons.newInstance("Tom", 12);
        System.out.println(tom.toString());

        //2.通过反射,调用对象指定的属性和方法
        //调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(tom, 10);
        System.out.println(tom);

        //调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(tom);

        //通过反射,可以调用Person类的私有结构,比如私有的构造器,方法,属性
        //调用私有的构造器
        Constructor<Person> cons1 = personClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person jerry = cons1.newInstance("Jerry");
        System.out.println(jerry);

        //调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jerry, "Harry");
        System.out.println(jerry);

        //调用私有的方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(jerry, "China");//相当于String nation = jerry.showNation("China")
        System.out.println(nation);
    }

}
