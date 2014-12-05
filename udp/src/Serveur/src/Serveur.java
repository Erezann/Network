/**
 * 
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author apple
 * 
 */
public class Serveur {
    private static final int PORT = 9876;
    private static final int MAX = 1024;
    private static final String IP_ADDRESS = "192.168.1.12";
    private static final String BEGIN = "Begin...";
    private static final String RECEIVE = "Recieve: ";
    private DatagramSocket serverSocket = null;
    private DatagramPacket serverPacket = null;
    private byte[] buffer = new byte[MAX];
    private InetSocketAddress socketAddress = null;

    // private String orgIp;

    public Serveur() throws SocketException {
        socketAddress = new InetSocketAddress(IP_ADDRESS, PORT);
        serverSocket = new DatagramSocket(socketAddress);
        System.out.println(BEGIN);
    }

    public String receive() throws IOException {
        serverPacket = new DatagramPacket(buffer, buffer.length);
        serverSocket.receive(serverPacket);
        // orgIp = serverPacket.getAddress().getHostAddress();
        String in = new String(serverPacket.getData(), 0,
                serverPacket.getLength());
        System.out.println(RECEIVE + in);
        return in;
    }

    public void response(String info) throws IOException {
        // System.out.println("Client Address: "
        // + serverPacket.getAddress().getHostAddress() + ", Port: "
        // + serverPacket.getPort());
        DatagramPacket clientPacket = new DatagramPacket(buffer, buffer.length,
                serverPacket.getAddress(), serverPacket.getPort());
        clientPacket.setData(info.getBytes());
        serverSocket.send(clientPacket);
    }
}
