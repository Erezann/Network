/**
    Host Client for a socket communication
 * 
 */
package socket;

import java.io.*;
import java.net.*;


/**
 * @author ZHU Yuting
 * @version 06/11/2014
 * 
 */
public class Client {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static final String IP_ADDRESS = "192.168.1.12";
    private static final int PORT = 9874;

    private final static String END_CONNEXION="stop";
    private final static String CLIENT_NAME="Client :";
    private final static String SERVER_NAME="Server :";
    private final static String ERROR="Error";
    private final static String END="End of connexion";

    public Client() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader line = new BufferedReader(new InputStreamReader(
                    System.in));
            String serveurAnswer="";
            String strline; // input by user
            strline = line.readLine();
            while (!strline.equalsIgnoreCase(END_CONNEXION) && serveurAnswer!=null) {
                out.println(strline);
                out.flush();
                System.out.println(CLIENT_NAME + strline);
                serveurAnswer=in.readLine();
                System.out.println(SERVER_NAME + serveurAnswer);
                strline = line.readLine();
            }
            out.println(strline);
            out.flush();

            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(ERROR + e);
        }

        System.out.println(END);
    }

}
