package Cheaper13;


import org.junit.Test;

import java.io.*;

/**
 * @author wxh
 * @description
 *
 * 一. 流的分类
 * 1. 操作数据单位: 字节流,字符流
 * 2. 数据的流向:输入流, 输出流
 * 3. 流的角色: 节点流, 处理流
 *
 * 二. 流的体系结构
 * 抽象基类              节点流(或文件流)            缓冲流(处理流的一种)
 * InputStream           FileInputStream           BufferedInputStream
 * OutputStream          FileOutputStream          BufferedOutputStream
 * Reader                FileReader                BufferedReader
 * Writer                FileWriter                BufferedWriter
 *
 * 结论:对于文本文件(.txt,.java,.c,.cpp),使用字符流处理
 *      对于非文本文件,使用字节流处理
 * @create 2022-12-24 10:25
 */
public class FileReaderWriterTest {

    /**
     * 将Hello.txt文件内容读入程序中,并输出到控制台
     *
     * 说明:
     * 1.read()的理解:返回读入的一个字符,如果到达文件末尾,返回-1
     * 2.异常的处理:为了保证流资源一定可以执行关闭操作,需要使用try-catch-finally来处理
     * 3.读入的文件一定要存在,否则会报FileNotFoundException
     */

    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1.实例化File类的对象,指明要操作的文件
            File file = new File("Hello.txt");//相较于当前module
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read():返回读入的一个字符,如果达到文件末尾,返回-1
            //方式一:
//        int read = fr.read();
//        while (read != -1) {
//            System.out.println((char) read);
//            read = fr.read();
//        }
//

            //方式二:
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();//4.流的关闭操作
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    @Test
    public void testFileReader1() {

        FileReader fileReader = null;

        try {
            File file = new File("Hello.txt");
            fileReader = new FileReader(file);

            //read(char[] chars):返回每次读入chars数组中的字符的个数,如果达到文件末尾,返回-1
            char[] chars = new char[5];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
//                for (int i = 0; i < len; i++) {
//                    System.out.print(chars[i]);
//                }
                String str = new String(chars, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    //从字符中写出数据到硬盘的文件里
    /**
     * 说明:
     * 1.输出操作,对应的File可以不存在的,并不会报异常
     *      如果不存在,在输出的过程中,会自动创建此文件
     *      如果存在:
     *          如果流使用的构造器是:FileWriter(file, false) / FileWriter(file):对原有文件的覆盖
     *          如果流使用的构造器是:FileWriter(file, true):不会对原有文件覆盖,而是在原有文件上向后添加
     *
     * @throws IOException
     */
    @Test
    public void testFileWriter() {
        //1.提供File类的对象,指明写出到的文件
        FileWriter fileWriter = null;
        try {
            File file = new File("hello1.txt");
            //2.提供FileWriter的对象,用于数据的写出
            fileWriter = new FileWriter(file);
            //3.写出的操作
            fileWriter.write("I have a dream!");
            fileWriter.write("Hello friends!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.该资源的关闭
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    @Test
    public void testFileReaderFileWriter() {
        //1.创建File类的对象,指明读入和写出的文件
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("Hello.txt");
            File destFile = new File("hello2.txt");
            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3.数据的读入和写出操作
            char[] chars = new char[5];
            int len;//记录每次读入到chars数组中的字符的个数
            while ((len = fr.read(chars)) != -1) {
                //每次写出len个字符
                fw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void copyImage() {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            File srcFile = new File("吃水2.png");
            File destFile = new File("copy.png");

            fi = new FileInputStream(srcFile);
            fo = new FileOutputStream(destFile);

            byte[] img = new byte[5];
            int len;

            while ((len = fi.read(img)) != -1) {
                fo.write(img, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
