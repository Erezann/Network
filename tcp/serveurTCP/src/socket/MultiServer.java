/**
 * 
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZHU Yuting
 * 
 */
public class MultiServer {
    private static final int port = 9874;
    private ServerSocket serverSocket = null;

    private static final String CONNECT = "connected...";
    private static final String ERREUR = "ERROR";

    public MultiServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println(CONNECT);
    }

    public void server() throws IOException {
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ServerThread(clientSocket);
            }
        } catch (IOException e) {
            System.err.println(ERREUR);
        } finally {
            serverSocket.close();
        }
    }

    class ServerThread extends Thread {
        private Socket clientSocket;
        private BufferedReader bufferedReader;
        private PrintWriter printWriter;

        private String CLIENT_IN = "One new client " + this.getName()
                + " comes in...";
        private String CLIENT_SAY = "Client " + this.getName() + " says: ";
        private String CLIENT_BYE = "Bye, " + this.getName();
        private String CLIENT_EXIT = this.getName() + " exit...";
        private static final String STOP = "stop";

        public ServerThread(Socket socket) throws IOException {
            super("MultiServerThread");
            this.clientSocket = socket;
            bufferedReader = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream())); // read the input of the
                                                     // client
            printWriter = new PrintWriter(clientSocket.getOutputStream(), true); // write
                                                                                 // to
                                                                                 // the
                                                                                 // client          
            System.out.println(CLIENT_IN);
            start();
        }

        public void run() {
            try {
                String in = null;
                in = bufferedReader.readLine();
                while (!in.equalsIgnoreCase(STOP)) {
                    System.out.println(CLIENT_SAY + in);
                    // printWriter.println(); Here add the messages to the
                    // client
                    // printWriter.flush();
                    in = bufferedReader.readLine();
                }
                // printWriter.println(CLIENT_BYE);
                System.out.println(CLIENT_EXIT);
                printWriter.close();
                bufferedReader.close();
                clientSocket.close();
            } catch (IOException e) {
                System.err.println(ERREUR);
            }
        }
    }
}
