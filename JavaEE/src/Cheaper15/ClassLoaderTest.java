package Cheaper15;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类的加载器
 *
 * @author wxh
 * @create 2022-12-26 16:00
 */
public class ClassLoaderTest {

    @Test
    public void test1() {
        //对于自定义类,使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent():获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //调用扩展类加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库,无法加载自定义类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader strParent = String.class.getClassLoader();
        System.out.println(strParent);
    }


    /**
     * Properties:用来读取配置文件
     */
    @Test
    public void test2() throws IOException {

        Properties properties = new Properties();
        //此时的文件默认在当前module下
        //读取配置文件方式一:
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        properties.load(fis);

        //方式二:使用ClassLoader
        //配置文件默认识别为:当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = " + user + " password = " + password);

    }

}
