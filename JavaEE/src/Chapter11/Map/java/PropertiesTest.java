package Chapter11.Map.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author wxh
 * @description
 *
 * Properties:常用来处理配置文件,key和value都是String类型
 *
 * @create 2022-12-20 11:31
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");

        pros.load(fis);
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name = " + name + ", password = " + password);
        fis.close();
    }

}
