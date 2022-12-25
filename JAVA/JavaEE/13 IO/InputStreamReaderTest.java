package IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author wxh
 * @description
 *
 * 转换流的使用
 * 1.转换流:属于字符流
 *      InputStreamReader:将一个字节的输入流转换为字符的输入流
 *      OutputStreamWriter:将一个字符的输出流转换为字节的输出流
 *
 * 2.作用:提供字节流与字符流之间的转换
 *
 * 3.解码: 字节,字节数组 ---> 字符数组,字符串
 *   编码: 字符数组,字符串 ---> 字节,字节数组
 *
 * 4.字符集
 *
 * @create 2022-12-24 14:58
 */
public class InputStreamReaderTest {

    @Test
    public void test1() {
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("Hello.txt");
            isr = new InputStreamReader(fis);

            char[] buf = new char[20];
            int len;
            while ((len = isr.read(buf)) != -1) {
                String str = new String(buf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
