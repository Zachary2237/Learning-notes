package Chapter15.Part2;

import Chapter15.Part2.test.Person1;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author wxh
 * @create 2022-12-27 14:01
 */
public class OtherTest {

    @Test
    public void test1() {

        Class<Person1> clazz = Person1.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor c : constructors) {
            System.out.println(c);
        }

        System.out.println("***********");

        //getDeclaredConstructors():获取当前运行时类中所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();

        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }

    }

    @Test
    public void test2() {

        Class<Person1> clazz = Person1.class;

        //获取运行时类的父类
        Class<? super Person1> superclass = clazz.getSuperclass();
        System.out.println(superclass);

    }

    @Test
    public void test3() {
        //获取运行时类的带泛型的父类
        Class<Person1> clazz = Person1.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        //获取泛型类型
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();

        for (Type t : actualTypeArguments) {
            System.out.println(t.getTypeName());
        }
    }

    @Test
    public void test4() {
        //获取运行时类实现的接口
        Class<Person1> clazz = Person1.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        System.out.println();

        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();

        for (Class c : interfaces1) {
            System.out.println(c);
        }

    }

    @Test
    public void test5() {
        //获取运行时类所在的包
        Class<Person1> clazz = Person1.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    @Test
    public void test6() {

        Class<Person1> clazz = Person1.class;
        Annotation[] annotations = clazz.getAnnotations();

        for (Annotation a : annotations) {
            System.out.println(a);
        }

    }

}
