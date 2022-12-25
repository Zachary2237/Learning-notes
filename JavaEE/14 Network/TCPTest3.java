package Network;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 实现TCP的网络编程
 * 例题3:从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给户端。并关闭相应的连接。
 *
 * @author wxh
 * @create 2022-12-25 14:32
 */
public class TCPTest3 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress inet = InetAddress.getByName("192.168.101.18");
            socket = new Socket(inet, 9090);

            os = socket.getOutputStream();

            bis = new BufferedInputStream(new FileInputStream("01.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            socket.shutdownOutput();


            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] print = new byte[20];
            int length;
            while ((length = is.read(print)) != -1) {
                baos.write(print, 0, length);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
        }


    }

    @Test
    public void server() {

        ServerSocket socket = null;
        Socket accept = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        try {
            socket = new ServerSocket(9090);

            accept = socket.accept();

            is = accept.getInputStream();

            bos = new BufferedOutputStream(new FileOutputStream("03.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            System.out.println("Success!");
            System.out.println("收到来自" + accept.getInetAddress().getHostAddress() + "的文件");

            os = accept.getOutputStream();
            os.write("Success!发送成功".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
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

            if (accept != null) {
                try {
                    accept.close();
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

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
