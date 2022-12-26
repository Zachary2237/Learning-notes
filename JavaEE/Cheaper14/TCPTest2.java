package Cheaper14;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2:客户端发送文件到服务器端,服务端将文件保存在本地
 *
 * @author wxh
 * @create 2022-12-25 14:16
 */
public class TCPTest2 {

    @Test
    public void client() throws IOException {

        Socket socket = new Socket("192.168.101.18", 8989);

        OutputStream os = socket.getOutputStream();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("01.jpg"));

        byte[] buffer = new byte[1024];
        int len;

        while ((len = bis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        bis.close();
        os.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {

        ServerSocket ss = new ServerSocket(8989);

        Socket accept = ss.accept();

        InputStream is = accept.getInputStream();

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("02.jpg"));

        byte[] buffer = new byte[1024];
        int len;

        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        bos.close();
        is.close();
        accept.close();
        ss.close();

    }

}
