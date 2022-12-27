package Chapter15.Part2;

import Chapter15.Part1.Person;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 *
 * 通过反射创建对应的运行时类的对象
 *
 * @author wxh
 * @create 2022-12-27 10:10
 */
public class NewInstanceTest {

    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //newInstance():使用构造器调用此方法,创建对应的运行时类的对象
        //在javabean中要求提供一个public的空参构造器,这样可以:
        //1.便于通过反射创建运行时类的对象
        //2.便于子类继承此运行时类时,默认调用super()时,保证父类有此构造器
        Person person = clazz.getDeclaredConstructor().newInstance();
        System.out.println(person);
    }

    @Test
    public void test2() {

        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "Cheaper15.Part1.Person";
                break;
        }

        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.getDeclaredConstructor().newInstance();
    }

}
