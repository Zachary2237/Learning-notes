package Network;

import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * UDP协议网络编程
 *
 * @author wxh
 * @create 2022-12-25 15:57
 */
public class UDPTest {

    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();

        String str = "I'm UDP!";
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 9090);

        socket.send(packet);
        socket.close();


    }

    @Test
    public void receiver() throws  IOException {

        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];

        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

    }

}
