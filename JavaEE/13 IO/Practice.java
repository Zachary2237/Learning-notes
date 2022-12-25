package IO;

import org.junit.Test;

import javax.print.DocFlavor;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wxh
 * @description
 * @create 2022-12-24 13:59
 */
public class Practice {

    @Test
    public void secret() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("加密.png")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("解密.png")));

            byte[] buf = new byte[10];
            int len;

            while ((len = bis.read(buf)) != -1) {
                for (int i = 0; i < len; i++) {
                    buf[i] = (byte) (buf[i] ^ 5);
                }

                bos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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


    }

    @Test
    public void numsOfChars() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("Hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("index.txt")));

            char[] buf = new char[1];
            int len;
            Map<Character, Integer> map = new HashMap<>();
            while ((len = br.read(buf)) != -1) {
                map = count(buf[0], map);
            }

            bw.write(map.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }


    public Map<Character, Integer> count(char c, Map<Character, Integer> map) {

        if (map.containsKey(c)) {
            map.replace(c, (map.get(c) + 1));
        } else {
            map.put(c, 1);
        }

        return map;
    }

}
