/**
 * 
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author apple
 * 
 **/
//test
public class Client {
    private DatagramSocket clientSocket = null;
    private byte[] buffer = new byte[1024];;
    private static final int TIMEOUT = 60;
    private static final int PORT = 9876;
    private static final String IP_ADDRESS="192.168.1.12";

    public Client() throws SocketException {
        clientSocket = new DatagramSocket();
        clientSocket.setSoTimeout(TIMEOUT);
    }

    public DatagramPacket send(String input)
            throws IOException {
        byte[] bytes=input.getBytes();
        DatagramPacket clientPacket = new DatagramPacket(bytes, bytes.length,
                InetAddress.getByName(IP_ADDRESS), PORT);
        clientSocket.send(clientPacket);
        return clientPacket;
    }

    public String receive() throws IOException {
        DatagramPacket clientPacket = new DatagramPacket(buffer, buffer.length);
        clientSocket.receive(clientPacket);
        String in = new String(clientPacket.getData(), 0,
                clientPacket.getLength());
        return in;
    }
}
