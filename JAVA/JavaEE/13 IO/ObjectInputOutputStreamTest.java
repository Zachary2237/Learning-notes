package IO;

import org.junit.Test;

import java.beans.VetoableChangeListenerProxy;
import java.io.*;

/**
 * @author wxh
 * @description
 *
 * 对象流的使用:
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用:用于存储和读取基本数据类型或对象的处理流.它的强大指出就是可以把Java中的对象写入到数据源中,
 *        也能把对象从数据源中还原回来
 * 3.要想一个java对象是可序列化的,需要满足一些要求
 *
 * 4.序列化机制:对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从
 *   而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
 *   当其它程序获取了这种二进制流，就可以恢复成原来的Java对象
 *
 * 序列化过程:将内存中的java对象保存到磁盘中或通过网络传输出去
 * 使用ObjectOutputStream实现
 *
 *
 *
 * 反序列化:将磁盘文件中的对象还原为内存中的一个java对象
 * 使用ObjectInputStream实现
 *
 * @create 2022-12-24 18:42
 */
public class ObjectInputOutputStreamTest {

    @Test
    public void testObjectOutputStream() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));

            oos.writeObject(new String("I love Java"));
            oos.flush();

            oos.writeObject(new Person("Tom", 18));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testObjectInputStream() {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;

            Person p = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



}
