package Network;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 实现TCP的网络编程
 * 例1:客户端向服务端发送信息,服务端将数据显示在控制台上
 *
 * @author wxh
 * @create 2022-12-25 11:56
 */
public class TCPTest1 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket对象,指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("192.168.101.18");
            socket = new Socket(inet, 8889);

            //2.获取一个输出流,用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            os.write("Hello, i'm client!".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的ServerSocket,指明自己的端口号
            ss = new ServerSocket(8889);
            //2.调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();

//        byte[] buffer = new byte[20];
//        int len;
//        while ((len = is.read(buffer)) != -1) {
//            String str = new String(buffer, 0, len);
//            System.out.println(str);
//        }

            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());
            System.out.println(socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.资源关闭
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }


}
