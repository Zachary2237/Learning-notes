package Cheaper13;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类,实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流,又可以作为一个输出流
 * 3.如果RandomAccessFile作为输出流时,写出的文件如果不存在,则在执行过程中自动创建
 *   如果写出的文件存在,则会对原有文件内容进行覆盖(默认情况下从头覆盖)
 * 4.可以通过相关的操作,实现RandomAccessFile"插入"数据的效果
 *
 * @author wxh
 * @create 2022-12-25 9:39
 */
public class RandomAccessFileTest {

    @Test
    public void test1() throws FileNotFoundException {

        RandomAccessFile r1 = new RandomAccessFile(new File("Hello.txt"), "r");
        RandomAccessFile r2 = new RandomAccessFile(new File("Hello1.txt"), "rw");

    }



}
