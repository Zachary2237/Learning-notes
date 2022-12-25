package IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.Arrays;

/**
 * @author wxh
 * @description
 *
 * File类的使用
 *
 * 1. File类的一个对象,代表一个文件或一个文件目录(文件夹)
 * 2. File类声明在java.io包下
 *
 * @create 2022-12-22 11:24
 */
public class FileTest {

    /**
     * 1. 如何创建File类的实例
     *
     * 2. 相对路径:相较于某个路径下,指明的路径
     *    绝对路径:包含盘符子啊内的文件或文件目录的路径
     */

    @Test
    public void test1() {
        File file = new File("hello.txt");
    }

    /**
     *
     *  File类的获取功能
     *  public String getAbsolutePath()：获取绝对路径
     *  public String getPath() ：获取路径
     *  public String getName() ：获取名称
     *  public String getParent()：获取上层文件目录路径。若无，返回null
     *  public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     *  public long lastModified() ：获取最后一次的修改时间，毫秒值
     *  public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
     *  public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     *
     */

    @Test
    public void test2() {
        File file = new File("hello.txt");
    }

    @Test
    public void test3() throws IOException {
        File file = new File("Hello.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Success");
        } else {
            System.out.println("1");
        }
    }

    @Test
    public void test4() {
        File file = new File("D:\\io\\io1");
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);
    }

    @Test
    public void test5() throws IOException {
        File file = new File("D:\\io\\io1");
        boolean newFile = file.mkdirs();
        if(newFile) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }

        String parent = file.getParent();
        System.out.println(parent);

        File file2 = new File(file.getPath(), "hello.txt");
        file2.createNewFile();

        File file1 = new File(parent, "nice.txt");
        boolean newFile1 = file1.createNewFile();
        if (newFile1) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }

        File fileDemo = new File("D:\\io");

        String[] list = fileDemo.list();
        for (String s : list) {
            if (s.endsWith(".txt")) {
                System.out.println(s);
            }
        }

        System.out.println(Arrays.toString(list));


    }

    @Test
    public void test6() {
        File path = new File("D:\\程序员的基本修养\\Java\\尚硅谷Java基础");

        printSubFile(path);
    }

    public void printSubFile(File path) {
        File[] files = path.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                printSubFile(file);
            } else {
                System.out.println(file.getPath());
            }
        }
    }

}
