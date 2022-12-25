package IO;

import org.junit.Test;

import java.io.*;

/**
 * @author wxh
 * @description
 *
 * 缓冲流的使用
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用:提供流的读取,写入的速度
 *   提高读写速度的原因:内部提供了一个缓冲区
 *
 *
 *
 * @create 2022-12-24 12:09
 */
public class BufferedTest {

    @Test
    public void BufferedStreamTest() {
        long startTime = System.currentTimeMillis();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("吃水2.png");
            File destFile = new File("copy2.png");

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭:先关闭外层的流,后关闭内层的流
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //说明:关闭外层流的同时,内层流也会自动关闭,关于内层流的关闭,我们可以省略
//        fos.close();
//        fis.close();

        long endTime = System.currentTimeMillis();

        System.out.println("The time: " + (endTime - startTime));

    }

}
